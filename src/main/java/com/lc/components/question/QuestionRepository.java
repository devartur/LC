package com.lc.components.question;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

public interface QuestionRepository extends JpaRepository<Question, Long> { 
	
	
	@Query("select q from Question q where ALL_QUESTIONS_ID in (select id from AllQuestions where firstLevel = :firstLevelValue)")
	List<Question> findSelectedQuestions(@Param("firstLevelValue") String firstLevelValue);
}

//select ID from ALL_QUESTIONS where FIRST_LEVEL = :firstLevelValue
/*
 * @Query("select a from Asset a where lower(a.name) like lower(concat('%', :search, '%')) "
 * + "or lower(a.serialNumber) like lower(concat('%', :search, '%'))")
 * List<Asset> findAllByNameOrSerialNumber(@Param("search") String search);
 */