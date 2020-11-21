package com.lc.application.component;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class MD5Encoder {
	private static final Logger LOG = LoggerFactory.getLogger(MD5Encoder.class);

	private static final String ALGORITHM = "MD5";
	
	private static final int HEX_BASE = 16;

	public String getMD5Hash(String password) {

		String md5Hash = null;
		if (password != null) {
			try {
				MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
				digest.update(password.getBytes(), 0, password.length());
				md5Hash = new BigInteger(1, digest.digest()).toString(HEX_BASE);
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
			}
		}

		return md5Hash;
	}
}
