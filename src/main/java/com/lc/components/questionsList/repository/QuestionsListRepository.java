package com.lc.components.questionsList.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lc.application.domain.QuestionsList;

public interface QuestionsListRepository  extends JpaRepository<QuestionsList, Long>{

	/*
	 * @Query("select ql.name, ql.description from QUESTIONS_LIST ql " +
	 * "inner join QUESTIONS_LIST_USERS qlu on qlu.questions_list_id=ql.id " +
	 * "where qlu.users_id = (select ID from USERS where open_id = :currentUserOpenId)"
	 * )
	 */
	
	 @Query("select ql from QuestionsList ql " 
			 + " join ql.users qlu  " 
			 //+ "where ql.id = :currentUserOpenId")
			 + "where qlu.id = (select id from User where open_id = :currentUserOpenId)")
	//select a.firstName, a.lastName from Book b join b.authors a where b.id = :id
	List<QuestionsList> findUserQuestionsList(String currentUserOpenId);

}
