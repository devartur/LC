package com.lc.components.question;

import java.sql.Date;

import javax.persistence.*;

import com.lc.components.users.User;

@Entity
public class DetailsQuestion {
	
	
	
	
	  @Id private Long id; 
	  
	// @ManyToOne
	  //@JoinColumn(name = "user_id")
	//  private User user;
	  private int numberAnswerCorrect; 
	  private int numberAnswerWrong; 
	  private Date dateLastAnswer; 
	  private Date dateNextAnswer;
	  
	  @ManyToOne
	  @JoinColumn(name = "question_id") 
	  private Question question;
	 
	  
	  private boolean isShowInAllQuestion; // czy pytanie będzie dalej wyświetlana w listach zadań do dodania
	  private boolean isShowInMyQuestion; // czy pytanie będzie dalej wyświetlana w moich zadaniach
		
	

}
