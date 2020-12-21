package com.lc.components.questionsList.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lc.components.questionsList.dto.QuestionsListDto;
import com.lc.components.questionsList.dto.QuestionsListMapper;
import com.lc.components.questionsList.repository.QuestionsListRepository;
import com.lc.login.component.CurrentUser.CurrentUser;

@Service
public class QuestionsListService {
	
	QuestionsListRepository questionsListRepository;
	
	public QuestionsListService(QuestionsListRepository questionsListRepository) {
		this.questionsListRepository = questionsListRepository;
	}
	
	public List<QuestionsListDto> findUserQuestionsList(){
		
		return questionsListRepository.findUserQuestionsList(CurrentUser.getCurrentUserOpenId())
				.stream().map(QuestionsListMapper::toDto)
				.collect(Collectors.toList());
	};

}
