package com.lc.components.feedback;

public class FeedbackMapper {
	
	private FeedbackMapper() {
	}

	static FeedbackDto toDto(Feedback feedback) {
		FeedbackDto dto = new FeedbackDto();
		dto.setId(feedback.getId());
		dto.setSubject(feedback.getSubject());
		dto.setEmail(feedback.getEmail());
		dto.setFeedback(feedback.getFeedback()); //text message
		return dto;
	}

	static Feedback toEntity(FeedbackDto feedback) {
		Feedback entity = new Feedback();
		entity.setId(feedback.getId());
		entity.setSubject(feedback.getSubject());
		entity.setEmail(feedback.getEmail());
		entity.setFeedback(feedback.getFeedback()); // text message
		return entity;
	}
}
