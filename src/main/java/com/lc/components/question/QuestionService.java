package com.lc.components.question;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class QuestionService {

	
	private QuestionRepository questionRepository;
	 
	QuestionService(QuestionRepository questionRepository){
		 this.questionRepository = questionRepository;
	 }
	
	 List<QuestionDto> findAll() {
	        return questionRepository.findAll()
	                .stream()
	                .map(QuestionMapper::toDto)
	                .collect(Collectors.toList());
	    }

	public List<QuestionDto> findQuestionsByIdAndLevel(String firstLevelValue) {
		return questionRepository.findSelectedQuestions(firstLevelValue)
                .stream()
                .map(QuestionMapper::toDto)
                .collect(Collectors.toList());
	}
}
