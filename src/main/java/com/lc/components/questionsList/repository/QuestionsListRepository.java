package com.lc.components.questionsList.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lc.application.domain.QuestionsList;

public interface QuestionsListRepository  extends JpaRepository<QuestionsList, Long>{


	 @Query("select ql from QuestionsList ql " 
			 + " join ql.users qlu  " 
			 + "where qlu.id = (select id from User where open_id = :currentUserOpenId)")
	List<QuestionsList> findUserQuestionsList(String currentUserOpenId);

}
