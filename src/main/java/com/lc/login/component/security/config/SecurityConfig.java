package com.lc.login.component.security.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import com.lc.login.component.security.CustomAuthSuccessHandler;
import com.lc.login.component.security.CustomLogoutSuccessHandler;
import com.lc.application.component.MD5Encoder;
import com.lc.login.component.security.CustomAuthEntryPoint;
import com.lc.login.component.security.CustomAuthFailureHandler;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private CustomAuthSuccessHandler authSuccessHandler;

	private CustomAuthFailureHandler authFailureHandler;

	private CustomLogoutSuccessHandler logoutSuccessHandler;

	private CustomAuthEntryPoint authEntryPoint;

	private DataSource dataSource;

	private MD5Encoder md5Encoder;

	@Autowired
	public SecurityConfig(CustomAuthSuccessHandler authSuccessHandler, CustomAuthFailureHandler authFailureHandler,
			CustomLogoutSuccessHandler logoutSuccessHandler, CustomAuthEntryPoint authEntryPoint, DataSource dataSource,
			MD5Encoder md5Encoder) {
		super();
		this.authSuccessHandler = authSuccessHandler;
		this.authFailureHandler = authFailureHandler;
		this.logoutSuccessHandler = logoutSuccessHandler;
		this.authEntryPoint = authEntryPoint;
		this.dataSource = dataSource;
		this.md5Encoder = md5Encoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http://localhost:8080/api/user/login
		//http://localhost:8080/api/user/register
		

		http.csrf().disable()
				/*
				 * .csrfTokenRepository(csrfTokenRepository()).and() //CSRF
				 * .addFilterAfter(csrfHeaderFilter(), CsrfFilter.class)
				 */
        .headers().frameOptions().sameOrigin()
				/*
				 * .and().cors().configurationSource(request -> {//CORS CorsConfiguration
				 * corsConfiguration = new CorsConfiguration();
				 * corsConfiguration.addAllowedOrigin("http://localhost:4200");
				 * corsConfiguration. return corsConfiguration; })
				 */
		.and().authorizeRequests().antMatchers("/login","/api/user/register").permitAll()
		.anyRequest().authenticated().and().formLogin()
		.successHandler(authSuccessHandler).failureHandler(authFailureHandler)
		.loginProcessingUrl("/login")
		.usernameParameter("email").passwordParameter("password").permitAll().and().exceptionHandling()
		.authenticationEntryPoint(authEntryPoint).and().logout().invalidateHttpSession(true)
		.deleteCookies("JSESSIONID").logoutSuccessHandler(logoutSuccessHandler);
		
	}

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
				.usersByUsernameQuery("select email, password, active from users where email=?")
				.authoritiesByUsernameQuery(
						"select u.email, r.role_name from users_roles ur left join users u on u.id=ur.user_id left join "
								+ "roles r on r.id=ur.role_id where email=?");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new PasswordEncoder() {

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return md5Encoder.getMD5Hash(rawPassword.toString()).equals(encodedPassword);
			}

			@Override
			public String encode(CharSequence rawPassword) {
				return md5Encoder.getMD5Hash(rawPassword.toString());
			}
		};
	}
	
	private Filter csrfHeaderFilter() {
	    return new OncePerRequestFilter() {

	        @Override
	        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
	                                        FilterChain filterChain) throws ServletException, IOException {

	            CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
	            if (csrf != null) {
	                Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
	                String token = csrf.getToken();
	                if (cookie == null || token != null && !token.equals(cookie.getValue())) {
	                    cookie = new Cookie("XSRF-TOKEN", token);
	                    cookie.setPath("http://localhost:4200"); //tutaj nazwa domeny
	                    response.addCookie(cookie);
	                }
	            }
	            filterChain.doFilter(request, response);
	        }
	    };
	}

	private CsrfTokenRepository csrfTokenRepository() {
	    HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
	    repository.setHeaderName("X-XSRF-TOKEN");
	    return repository;
	}

}
