package com.lc.components.feedback;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lc.application.domain.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> { }

