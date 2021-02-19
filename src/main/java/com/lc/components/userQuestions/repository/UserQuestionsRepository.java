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

	/*
	 * @Query( "select q from Question q " + " join q.questionsLists qql " +
	 * " join q.questionAddInfos qqai  " + " join qqai.user qqaiu  " +
	 * " where qql.id = :questionsListId" +
	 * " and qqaiu.id = (select id from User where open_id = :currentUserOpenId)")
	 */

	/*
	 * @Query("select q from Question q " +
	 * " join q.questionsLists qql on q.id = qql.question_id  " +
	 * " join q.questionAddInfos qqai on q.id = qqai.question  " +
	 * " where q.id in (select questions_id from qql where qql.id = :questionsListId)"
	 * +
	 * " and qqai.user.id = (select id from User where open_id = :currentUserOpenId)"
	 * )
	 */
//@Param("status")
	
	  @Query( value =
	  		"SELECT * FROM QUESTION Q " + 
	  		"LEFT OUTER JOIN QUESTION_ADD_INFO QAI on Q.ID = QAI.QUESTION_ID " + 
	  		"WHERE QAI.USER_ID = (SELECT ID FROM USER WHERE OPEN_ID = :currentUserOpenId) " + 
	  		"and Q.ID IN (SELECT QUESTIONS_ID  FROM QUESTIONS_LIST_QUESTIONS WHERE QUESTIONS_LIST_ID = :questionsListId )",
	  		 nativeQuery = true)
	 
	List<Question> findUserQuestionsByQuestionsList(String currentUserOpenId, Long questionsListId);

}
