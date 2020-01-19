package com.lc.components.allQuestions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


@Service
public class AllQuestionsService {

	
	 private AllQuestionsRepository allQuestionsRepository;
	 
	 AllQuestionsService(AllQuestionsRepository allQuestionsRepository){
		 this.allQuestionsRepository = allQuestionsRepository;
	 }
	 
	 List<AllQuestionsDto> findAll() {
	        return allQuestionsRepository.findAll()
	                .stream()
	                .map(AllQuestionsMapper::toDto)
	                .collect(Collectors.toList());
	    }
	 
}
