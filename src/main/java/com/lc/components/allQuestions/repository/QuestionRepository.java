package com.lc.components.allQuestions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lc.application.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> { 
	
	
	@Query("select q from Question q where ALL_QUESTIONS_ID in (select id from AllQuestions where firstLevel = :firstLevelValue)")
	List<Question> findSelectedQuestionsForFirstLevel(@Param("firstLevelValue") String firstLevelValue);

	@Query("select q from Question q where ALL_QUESTIONS_ID in (select id from AllQuestions where firstLevel = :firstLevelValue and secondLevel = :secondLevelValue)")
	List<Question> findSelectedQuestionsForSecondLevel(@Param("firstLevelValue") String firstLevelValue, @Param("secondLevelValue") String secondLevelValue);
	
	@Query("select q from Question q where ALL_QUESTIONS_ID in (select id from AllQuestions where firstLevel = :firstLevelValue and secondLevel = :secondLevelValue and thirdLevel = :thirdLevelValue )")
	List<Question> findSelectedQuestionsForThirdLevel(@Param("firstLevelValue") String firstLevelValue, @Param("secondLevelValue") String secondLevelValue,@Param("thirdLevelValue") String thirdLevelValue);
	
	@Query("select q from Question q where ALL_QUESTIONS_ID in (select id from AllQuestions where firstLevel = :firstLevelValue and secondLevel = :secondLevelValue and thirdLevel = :thirdLevelValue and fourthLevel = :fourthLevelValue  )")
	List<Question> findSelectedQuestionsFourthLevel(@Param("firstLevelValue") String firstLevelValue, @Param("secondLevelValue") String secondLevelValue, @Param("thirdLevelValue") String thirdLevelValue, @Param("fourthLevelValue") String fourthLevelValue);
	




}