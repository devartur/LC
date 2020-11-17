package com.lc.components.question;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lc.components.allQuestions.AllQuestions;
import com.lc.components.allQuestions.AllQuestionsRepository;

@Service
public class QuestionService {

	
	private QuestionRepository questionRepository;
	private AllQuestionsRepository allQuestionsRepository;
	 
	QuestionService(QuestionRepository questionRepository, AllQuestionsRepository allQuestionsRepository){
		 this.questionRepository = questionRepository;
		 this.allQuestionsRepository = allQuestionsRepository;
	 }
	
	 List<QuestionDto> findAll() {
	        return questionRepository.findAll()
	                .stream()
	                .map(QuestionMapper::toDto)
	                .collect(Collectors.toList());
	    }

	public List<QuestionDto> findQuestionsByIdAndLevel(Long id, String level) {
		
		Optional<AllQuestions> allQuestionById = allQuestionsRepository.findById(id);
		if(allQuestionById.isPresent() ){
		
		  switch (level) {
		case "firstLevel":
			
			return questionRepository.findSelectedQuestionsForFirstLevel(allQuestionById.get().getFirstLevel())
	                .stream()
	                .map(QuestionMapper::toDto)
	                .collect(Collectors.toList());
			
			
		case "secondLevel":
			
			return questionRepository.findSelectedQuestionsForSecondLevel(allQuestionById.get().getFirstLevel(),allQuestionById.get().getSecondLevel())
	                .stream()
	                .map(QuestionMapper::toDto)
	                .collect(Collectors.toList());
			
		case "thirdLevel":
			
			return questionRepository.findSelectedQuestionsForThirdLevel(allQuestionById.get().getFirstLevel(), allQuestionById.get().getSecondLevel(), allQuestionById.get().getThirdLevel())
	                .stream()
	                .map(QuestionMapper::toDto)
	                .collect(Collectors.toList());
			
		case "fourthLevel":
			
			return questionRepository.findSelectedQuestionsFourthLevel(allQuestionById.get().getFirstLevel(), allQuestionById.get().getSecondLevel(), allQuestionById.get().getThirdLevel(), allQuestionById.get().getFourthLevel())
	                .stream()
	                .map(QuestionMapper::toDto)
	                .collect(Collectors.toList());
			

		default:
			break;
		}
		}
		return null; // rzucić wyjątek 
	}
}
