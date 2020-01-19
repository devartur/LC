package com.lc.components.question;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lc.components.feedback.FeedbackDto;

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
    	 
		    if(level.equals("firstLevel")) {
		    	System.out.println(questionService.findQuestionsByIdAndLevel(firstLevelValue));
		    	return questionService.findQuestionsByIdAndLevel(firstLevelValue);
		    	}
	        return null;
    }
}
