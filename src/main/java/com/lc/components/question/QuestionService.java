package com.lc.components.question;

import org.springframework.stereotype.Service;

@Service
public class QuestionService {

	
	private QuestionRepository questionRepository;
	 
	QuestionService(QuestionRepository questionRepository){
		 this.questionRepository = questionRepository;
	 }
}
