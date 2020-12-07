package com.lc.components.allQuestions.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lc.components.allQuestions.dto.AllQuestionsDto;
import com.lc.components.allQuestions.dto.AllQuestionsMapper;
import com.lc.components.allQuestions.repository.AllQuestionsRepository;


@Service
public class AllQuestionsService {

	
	 private AllQuestionsRepository allQuestionsRepository;
	 
	 AllQuestionsService(AllQuestionsRepository allQuestionsRepository){
		 this.allQuestionsRepository = allQuestionsRepository;
	 }
	 
	public List<AllQuestionsDto> findAll() {
	        return allQuestionsRepository.findAll()
	                .stream()
	                .map(AllQuestionsMapper::toDto)
	                .collect(Collectors.toList());
	    }
	 
}
