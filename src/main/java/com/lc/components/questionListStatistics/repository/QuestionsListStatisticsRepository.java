package com.lc.components.questionListStatistics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lc.application.domain.QuestionAddInfo;
import com.lc.application.domain.QuestionsList;

public interface QuestionsListStatisticsRepository extends JpaRepository<QuestionsList, Long> {

	@Query(value = "select COUNT(*)  "
			+ "	from QUESTION_ADD_INFO QAI join QUESTION  Q on Q.ID = QAI.QUESTION_ID " 
			+ "		where "
			+ "		  	(QUESTION_ID in (select QUESTIONS_ID  from QUESTIONS_LIST_QUESTIONS where QUESTIONS_LIST_ID = :questionsListId)) "
			+ "		  	and (QAI.USER_ID = (select ID from USER where OPEN_ID = :currentUserOpenId)) "
			, nativeQuery = true)	
	int getQuestionsNumber(String currentUserOpenId, Long questionsListId);


	@Query(value = "select COUNT(*)  "
			+ "	from QUESTION_ADD_INFO QAI join QUESTION  Q on Q.ID = QAI.QUESTION_ID " 
			+ "		where "
			+ "		  	(QUESTION_ID in (select QUESTIONS_ID  from QUESTIONS_LIST_QUESTIONS where QUESTIONS_LIST_ID = :questionsListId)) "
			+ "		  	and (QAI.USER_ID = (select ID from USER where OPEN_ID = :currentUserOpenId)) "
			+ "			and (QAI.IS_MARKED_AS_KNOW = 1)"
			, nativeQuery = true)
	int getQuestionsMarkedAsKnowNumber(String currentUserOpenId, Long questionsListId);
	

	@Query(value = "select COUNT(*)  "
			+ "	from QUESTION_ADD_INFO QAI join QUESTION  Q on Q.ID = QAI.QUESTION_ID " 
			+ "		where "
			+ "		  	(QUESTION_ID in (select QUESTIONS_ID  from QUESTIONS_LIST_QUESTIONS where QUESTIONS_LIST_ID = :questionsListId)) "
			+ "		  	and (QAI.USER_ID = (select ID from USER where OPEN_ID = :currentUserOpenId)) "
			+ "         and (QAI.NEXT_ANSWER_DATE <= CURRENT_TIMESTAMP or QAI.NEXT_ANSWER_DATE is null)"
			+ "			and (QAI.IS_MARKED_AS_KNOW = 0)"
			, nativeQuery = true)
	int getRepetitionsTodayNumber(String currentUserOpenId, Long questionsListId);


	@Query(value = "select QAI.ID, QUESTION, QAI.IS_MARKED_AS_KNOW, QAI.MARKED_AS_KNOW_DATE "
			+ "			from QUESTION_ADD_INFO QAI join QUESTION  Q on Q.ID = QAI.QUESTION_ID "
			+ "				where "
			+ "		  		(QUESTION_ID in (select QUESTIONS_ID  from QUESTIONS_LIST_QUESTIONS where QUESTIONS_LIST_ID = :questionsListId)) "
			+ "		  		and (QAI.USER_ID = (select ID from USER where OPEN_ID = :currentUserOpenId)) "
			, nativeQuery = true)
	List<Object[]> findQuestionDataToStatistics(String currentUserOpenId, Long questionsListId);

}
