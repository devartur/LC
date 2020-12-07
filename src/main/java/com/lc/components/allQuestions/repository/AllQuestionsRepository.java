package com.lc.components.allQuestions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lc.application.domain.AllQuestions;


public interface AllQuestionsRepository extends JpaRepository<AllQuestions, Long> { }

