package com.lc.components.feedback;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class FeedbackService {
	
	 private FeedbackRepository feedbackRepository;
	 
	 FeedbackService(FeedbackRepository feedbackRepository){
		 this.feedbackRepository = feedbackRepository;
	 }
	 
	 
	 List<FeedbackDto> findAll() {
	        return feedbackRepository.findAll()
	                .stream()
	                .map(FeedbackMapper::toDto)
	                .collect(Collectors.toList());
	    }
	 
	 
	 Feedback save(FeedbackDto feedback) {
		 
		/*
		 * Feedback feedbackEntity = FeedbackMapper.toEntity(feedback); Feedback
		 * savedFeedback = feedbackRepository.save(feedbackEntity); return
		 * FeedbackMapper.toDto(savedFeedback);
		 */
		 
		 
		 Feedback feedbackEntity = FeedbackMapper.toEntity(feedback);
		 Feedback savedFeedback = feedbackRepository.save(feedbackEntity);
		    return savedFeedback;
	 }
}
	 