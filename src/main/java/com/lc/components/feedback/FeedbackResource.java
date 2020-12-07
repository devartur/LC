package com.lc.components.feedback;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lc.application.domain.Feedback;


@RestController
@RequestMapping("/api/feedback")
@CrossOrigin
public class FeedbackResource {
	
	private FeedbackService feedbackService;
	
	FeedbackResource(FeedbackService feedbackService){
		this.feedbackService = feedbackService;
	}
	
	 @GetMapping("")
	    List<FeedbackDto> findAll() {
	        return feedbackService.findAll();
	    }
	
	@PostMapping("")
	public Feedback save(@RequestBody FeedbackDto feedbackDto,
            BindingResult bindingResult){
		    
		    if (bindingResult.hasErrors()) {
		    	//rzuć wyjątek
	        }
		    
	        return feedbackService.save(feedbackDto);
		    
	}
}



