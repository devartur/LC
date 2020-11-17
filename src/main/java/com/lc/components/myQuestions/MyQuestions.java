package com.lc.components.myQuestions;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.lc.components.question.Question;


// jedem myQuestion wszystkie pytania które wybrał urzytkownik będą tutaj, dodam tabelę która będzie dzieliła je na zdefiniowane przez urzytkownika swoje kursy
@Entity
public class MyQuestions {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	String name;
	
	//@OneToOne
	//private User user;
	
	@ManyToMany
    private List<Question> questions;
	
	private Date creationTime;
	private String creationBy;
}
