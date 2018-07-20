package com.zoya.DojoOverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zoya.DojoOverflow.models.Answer;
import com.zoya.DojoOverflow.models.Question;
import com.zoya.DojoOverflow.services.AnswerService;
import com.zoya.DojoOverflow.services.QuestionService;




@Controller
public class Answers {
	private AnswerService answerService;
	private QuestionService questionService;
	
	
	public Answers(AnswerService answerService,QuestionService questionService) {
		this.answerService=answerService;
		this.questionService=questionService;
	}
	
	//add an Answer 
		@PostMapping("/answer/{id}")
			public String add(Model model,@Valid @ModelAttribute("addanswer") Answer answer ,BindingResult result,@PathVariable("id") Long id) {
			System.out.println(answer.getId());
			answer.setId(null);
			Answer ans=answerService.create(answer);
			
		
			
			
//			Question question = questionService.findById(id);
//			List<Answer> answers=question.getAnswers();
//			answers.add(answer);
//			question.setAnswers(answers);
//			questionService.update(question);
//			System.out.println(answers);
			
			return "redirect:/";
		}
}
