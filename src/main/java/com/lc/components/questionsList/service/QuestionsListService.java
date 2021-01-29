package com.lc.components.questionsList.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lc.application.domain.Question;
import com.lc.application.domain.QuestionsList;
import com.lc.components.allQuestions.repository.QuestionRepository;
import com.lc.components.questionsList.dto.request.QuestionsListRequestDto;
import com.lc.components.questionsList.dto.response.QuestionsListResponseDto;
import com.lc.components.questionsList.dto.response.QuestionsListResponseMapper;
import com.lc.components.questionsList.repository.QuestionsListRepository;
import com.lc.login.component.CurrentUser.CurrentUser;

@Service
public class QuestionsListService {

	QuestionsListRepository questionsListRepository;
	QuestionRepository questionRepository;

	public QuestionsListService(QuestionsListRepository questionsListRepository,
			QuestionRepository questionRepository) {
		this.questionsListRepository = questionsListRepository;
		this.questionRepository = questionRepository;
	}

	public List<QuestionsListResponseDto> findUserQuestionsList() {

		return questionsListRepository.findUserQuestionsList(CurrentUser.getCurrentUserOpenId()).stream()
				.map(QuestionsListResponseMapper::toDto).collect(Collectors.toList());
	}

	public QuestionsList addQuestionsToQuestionsList(QuestionsListRequestDto questionsListDto) {

		QuestionsList questionsListToUpdate = questionsListRepository.getOne(questionsListDto.getId());
		List<Question> questionsInQuestionsListToUpdate = questionsListToUpdate.getQuestions();

		addUniqueQuestionsToList(questionsInQuestionsListToUpdate, questionsListDto);

		QuestionsList savedQuestionsList = questionsListRepository.save(questionsListToUpdate);
		return savedQuestionsList;

	}

	private void addUniqueQuestionsToList(List<Question> questionsInQuestionsListToUpdate, QuestionsListRequestDto questionsListDto) {
	
		Set<Long> questionsInQuestionsListToUpdateIdSet = new HashSet<Long>();
		for (Question oneQuestion : questionsInQuestionsListToUpdate) {
			questionsInQuestionsListToUpdateIdSet.add(oneQuestion.getId());
		}

		List<Question> questionsToAdd = questionsListDto.getQuestions();
		Set<Long> questionsToAddIdSet = new HashSet<Long>();
		for (Question oneQuestion : questionsToAdd) {
			questionsToAddIdSet.add(oneQuestion.getId());
		}

		
		for (Long newQuestionId : questionsToAddIdSet) {
			if (!questionsInQuestionsListToUpdateIdSet.contains(newQuestionId)) {
				Question tempQuestion = questionRepository.findById(newQuestionId).orElse(null);
				questionsInQuestionsListToUpdate.add(tempQuestion);
			}

		}
	}

}
