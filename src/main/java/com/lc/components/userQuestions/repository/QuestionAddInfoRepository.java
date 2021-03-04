package com.lc.components.userQuestions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lc.application.domain.Question;
import com.lc.application.domain.QuestionAddInfo;

public interface QuestionAddInfoRepository extends JpaRepository<QuestionAddInfo, Long> {
	
	
	
	  @Query( value =
"select QAI.ID, QUESTION,  BASIC_ANSWER, INTERMEDIATE_ANSWER, ADVANCED_ANSWER, USER_NOTE \r\n" + 
"	from QUESTION_ADD_INFO QAI join QUESTION  Q on Q.ID = QAI.QUESTION_ID \r\n" + 
"		where \r\n" + 
"		  	(QUESTION_ID in (select QUESTIONS_ID  from QUESTIONS_LIST_QUESTIONS where QUESTIONS_LIST_ID = 1))\r\n" + 
"		  	and (QAI.USER_ID = (select ID from USER where OPEN_ID = 50420334)) \r\n" + 
"           and (QAI.NEXT_ANSWER_DATE <= CURRENT_TIMESTAMP or QAI.NEXT_ANSWER_DATE is null)"+
"			and (QAI.IS_MARKED_AS_KNOW = 0)"
	  , nativeQuery = true)
	 
		 //TODO do poprawy zapytanie(pobierz po questionsAddinfo), albo poprawić schemat bazy, jeszce do przemyślenia
		List<Object[]> findUserQuestionsByQuestionsList(String currentUserOpenId, Long questionsListId);

	
	@Query( value =
	  		"SELECT * FROM QUESTION_ADD_INFO QAI " + 
	  		"WHERE QAI.USER_ID = (SELECT ID FROM USER WHERE OPEN_ID = :currentUserOpenId) " + 
	  		"and QAI.QUESTION_ID = :questionId ",
	  		 nativeQuery = true)
	QuestionAddInfo getQuestionAddInfo(Long questionId, String currentUserOpenId);

}
