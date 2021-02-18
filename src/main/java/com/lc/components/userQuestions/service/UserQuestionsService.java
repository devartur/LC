package com.lc.components.userQuestions.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lc.components.userQuestions.dto.response.QuestionWithAddInfoResponseDto;
import com.lc.components.userQuestions.dto.response.QuestionWithAddInfoResponseDtoMapper;
import com.lc.components.userQuestions.repository.UserQuestionsRepository;
import com.lc.login.component.CurrentUser.CurrentUser;

@Service
public class UserQuestionsService {
	
	UserQuestionsRepository userQuestionsRepository;
	
	public UserQuestionsService(UserQuestionsRepository userQuestionsRepository){
		this.userQuestionsRepository = userQuestionsRepository;
	}

	public List<QuestionWithAddInfoResponseDto> findUserQuestionsWithAddInfoByUserQuestionsList(Long questionsListId) {
		return userQuestionsRepository
				//CurrentUser.getCurrentUserOpenId(),
				.findUserQuestionsByQuestionsList( questionsListId)
				.stream().map(QuestionWithAddInfoResponseDtoMapper::toDto).collect(Collectors.toList());
	}

}
