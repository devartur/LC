package com.lc.components.question;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class DetailsQuestion {
	
	
	
	
	  @Id private Long id; 
	  private int numberAnswerCorrect; 
	  private int numberAnswerWrong; 
	  private Date dateLastAnswer; 
	  private Date dateNextAnswer;
	  
	  @ManyToOne
	  @JoinColumn(name = "question_id") 
	  private Question question;
	 
	
	//private User user;

}
