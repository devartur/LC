package com.lc.components.feedback;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.ValidationException;
import org.springframework.validation.BindingResult;

import java.net.URI;
import java.util.List;


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
	            throw new ValidationException();
	        }
		    
	        return feedbackService.save(feedbackDto);
		    
	}
}



