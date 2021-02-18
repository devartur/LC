package com.lc.components.userQuestions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lc.application.domain.Question;

public interface UserQuestionsRepository extends JpaRepository<Question, Long> {

	/*
	 * @Query("select ql from QuestionsList ql " + " join ql.users qlu  " +
	 * "where qlu.id = (select id from User where open_id = :currentUserOpenId)")
	 */
	/*
	 * @Query("select q from Question q " + " join q.questionAddInfos qqai  " +
	 * " join qqai.user qqaiu  " + " join q.questionsLists qql  " +
	 * "where qqaiu.id = (select id from User where open_id = :currentUserOpenId)" +
	 * "  and qql.id = :questionsListId")
	 */
	 
	 @Query("select q from Question q " 
			 + " join q.questionsLists qql  "  
			 + " join q.questionAddInfos qqai  "
			 + "  where qql.id = :questionsListId")
	 //String open_id,
	List<Question> findUserQuestionsByQuestionsList( Long questionsListId);
	
}
