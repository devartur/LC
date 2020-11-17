package com.lc.components.users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.lc.components.myQuestions.MyQuestions;
import com.lc.components.question.DetailsQuestion;
import com.lc.components.question.Question;

public class User {
	
	@OneToMany(mappedBy = "user")
    private List<DetailsQuestion> detailsQuestion = new ArrayList<>();
	
	@OneToOne(mappedBy = "user")
    private MyQuestions myQuestions;
	
	

}
