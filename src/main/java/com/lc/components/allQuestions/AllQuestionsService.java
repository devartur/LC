package com.lc.components.allQuestions;

import org.springframework.stereotype.Service;


@Service
public class AllQuestionsService {

	
	 private AllQuestionsRepository allQuestionsRepository;
	 
	 AllQuestionsService(AllQuestionsRepository allQuestionsRepository){
		 this.allQuestionsRepository = allQuestionsRepository;
	 }
	 
}
