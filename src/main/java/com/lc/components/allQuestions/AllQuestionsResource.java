package com.lc.components.allQuestions;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/allQuestion")
@CrossOrigin
public class AllQuestionsResource {

	
	private AllQuestionsService allQuestionsService;

    public AllQuestionsResource(AllQuestionsService allQuestionsService) {
        this.allQuestionsService = allQuestionsService;
    }

}
