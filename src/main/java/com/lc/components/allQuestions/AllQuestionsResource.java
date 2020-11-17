package com.lc.components.allQuestions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lc.components.feedback.FeedbackDto;

@RestController
@RequestMapping("/api/all-questions-menu")
@CrossOrigin
public class AllQuestionsResource {

	
	private AllQuestionsService allQuestionsService;

    public AllQuestionsResource(AllQuestionsService allQuestionsService) {
        this.allQuestionsService = allQuestionsService;
    }
    
    
    @GetMapping("")
    List<AllQuestionsDto> findAll() {
    	List<AllQuestionsDto> lista = new ArrayList<AllQuestionsDto>();
    	lista = allQuestionsService.findAll();
    	
        return allQuestionsService.findAll();
    }

}
