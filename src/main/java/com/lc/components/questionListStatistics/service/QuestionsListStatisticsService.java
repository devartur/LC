package com.lc.components.questionListStatistics.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lc.components.questionListStatistics.dto.resopnse.QuestionDataToStatisticsResponseDto;
import com.lc.components.questionListStatistics.dto.resopnse.QuestionsListStatisticsResponseDto;
import com.lc.components.questionListStatistics.repository.QuestionsListStatisticsRepository;
import com.lc.components.userQuestions.dto.response.QuestionWithAddInfoResponseDto;
import com.lc.login.component.CurrentUser.CurrentUser;


@Service
public class QuestionsListStatisticsService {
	
	QuestionsListStatisticsRepository questionsListStatisticsRepository;
	
	public QuestionsListStatisticsService(QuestionsListStatisticsRepository questionsListStatisticsRepository){
		this.questionsListStatisticsRepository = questionsListStatisticsRepository;
		
	}

	public QuestionsListStatisticsResponseDto getQuestionsListStatistics(Long questionsListId) {
		
		 int questionsNumber = questionsListStatisticsRepository.getQuestionsNumber(CurrentUser.getCurrentUserOpenId(), questionsListId);
		 int questionsMarkedAsKnowNumber = questionsListStatisticsRepository.getQuestionsMarkedAsKnowNumber(CurrentUser.getCurrentUserOpenId(), questionsListId);
		 int repetitionsNumber = questionsNumber - questionsMarkedAsKnowNumber;
		 int repetitionsTodayNumber = questionsListStatisticsRepository.getRepetitionsTodayNumber(CurrentUser.getCurrentUserOpenId(), questionsListId);
		
		return new QuestionsListStatisticsResponseDto(
				questionsListId,
				questionsNumber,
				questionsMarkedAsKnowNumber,
				repetitionsNumber,
				repetitionsTodayNumber);
	}

	public List<QuestionDataToStatisticsResponseDto>  getQuestionDataToStatistics(Long questionsListId) {
		
		List<Object[]>  staInfoArr = questionsListStatisticsRepository
				.findQuestionDataToStatistics(CurrentUser.getCurrentUserOpenId(), questionsListId);
		
		List<QuestionDataToStatisticsResponseDto> result = convertNativeResultToPOJO(staInfoArr);
		
		return result;
	}

	private List<QuestionDataToStatisticsResponseDto> convertNativeResultToPOJO(List<Object[]> addInfoArr) {
		
		List<QuestionDataToStatisticsResponseDto> questionsToStatistics = addInfoArr
				.stream()
				.map(x -> new QuestionDataToStatisticsResponseDto(
						Long.valueOf(String.valueOf(x[0])),
						String.valueOf(x[1]),
						String.valueOf(x[2]), 
						formatDate(x[3])
						))
				.collect(Collectors.toList());
						
		return questionsToStatistics;
	}

	private String formatDate(Object x) {
		if(x!=null || String.valueOf(x).equals("null")) {
			return "-";
		}
		return new SimpleDateFormat("yyyy-MM-dd mm:ss").format(x);
	}

}
