package com.lc.components.userQuestions.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lc.application.domain.QuestionAddInfo;
import com.lc.components.userQuestions.dto.response.QuestionWithAddInfoResponseDto;
import com.lc.components.userQuestions.repository.QuestionAddInfoRepository;
import com.lc.login.component.CurrentUser.CurrentUser;

@Service
public class UserQuestionsService {

	private static final String IS_MARKED_AS_KNOW = "isMarkedAsKnow";
	QuestionAddInfoRepository questionAddInfoRepository;

	public UserQuestionsService(QuestionAddInfoRepository questionAddInfoRepository) {
		this.questionAddInfoRepository = questionAddInfoRepository;
	}

	public List<QuestionWithAddInfoResponseDto> findUserQuestionsWithAddInfoByUserQuestionsList(Long questionsListId) {
		
		
		List<Object[]>  addInfoArr = questionAddInfoRepository
				.findUserQuestionsByQuestionsList(CurrentUser.getCurrentUserOpenId(), questionsListId);
		
		List<QuestionWithAddInfoResponseDto> result = convertNativeResultToPOJO(addInfoArr);
		
		return result;
	}

	private List<QuestionWithAddInfoResponseDto> convertNativeResultToPOJO(List<Object[]> addInfoArr) {

		List<QuestionWithAddInfoResponseDto> questionWithAddInfo = addInfoArr
				.stream()
				.map(x -> new QuestionWithAddInfoResponseDto(
						Long.valueOf(String.valueOf(x[0])),
						String.valueOf(x[1]),
						String.valueOf(x[2]),
						String.valueOf(x[3]),
						String.valueOf(x[4]),
						String.valueOf(x[5]) ))
				.collect(Collectors.toList());
						
		return questionWithAddInfo;
	}

	public void partialUpdateQuestionWithAddInfo(Map<String, Object> updates, Long questionId) {

		if (updates.containsKey(IS_MARKED_AS_KNOW)) {
			updateQuestionAddInfo(updates, questionId);
		}

	}

	private void updateQuestionAddInfo(Map<String, Object> updates, Long questionId) {
		boolean isMarkedAsKnow = (boolean) updates.get(IS_MARKED_AS_KNOW);

		QuestionAddInfo qai = questionAddInfoRepository.getQuestionAddInfo(questionId,
				CurrentUser.getCurrentUserOpenId());
		qai.setMarkedAsKnow(isMarkedAsKnow);
		qai.setMarkedAsKnowDateTime(LocalDateTime.now());
		
		questionAddInfoRepository.save(qai);

	}

}
