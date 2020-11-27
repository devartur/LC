package com.lc.components.question;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class QuestionResource {
	
	private QuestionService questionService;

    public QuestionResource(QuestionService questionService) {
        this.questionService = questionService;
    }
    
    @GetMapping("all-questions")
    List<QuestionDto> findAll() {
        return questionService.findAll();
    }
	
	
    @GetMapping("selected-questions/")
    List<QuestionDto> findQuestionsByIdAndLevel(@RequestParam("firstLevelValue") Long id,
            @RequestParam("level") String level) {
    	 
		  
		    	return questionService.findQuestionsByIdAndLevel(id, level);
    }
}
