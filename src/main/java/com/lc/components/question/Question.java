package com.lc.components.question;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.lc.components.allQuestions.AllQuestions;

@Entity
public class Question {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String question;
	private String basicAnswer;
	private String intermediateAnswer;
	private String advancedAnswer;
	
	@ManyToOne
	@JoinColumn(name = "allQuestions_id")
	private AllQuestions allQuestions;
	
	//@OneToMany(mappedBy = "id")
	//private List<DetailsQuestion> detailQuestion;
	private Date creationTime;
	private String creationBy;
	private boolean isShowInAllQuestion; // czy pytanie będzie dalej wyświetlana w listach zadań do dodania
	private boolean isShowInMyQuestion; // czy pytanie będzie dalej wyświetlana w moich zadaniach
	
	
	
	
	//mapowanie z AllQuestions po questionLevel
}
