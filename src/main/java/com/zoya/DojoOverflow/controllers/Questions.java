package com.zoya.DojoOverflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.zoya.DojoOverflow.models.Answer;
import com.zoya.DojoOverflow.models.Question;
import com.zoya.DojoOverflow.models.Tag;
import com.zoya.DojoOverflow.services.QuestionService;
import com.zoya.DojoOverflow.services.TagService;



@Controller
public class Questions {
	
	private QuestionService questionService;
	private TagService tagService;
	
	public Questions(QuestionService questionService,TagService tagService) {
		this.questionService=questionService;
		this.tagService=tagService;
	}
	
	//display all
		@RequestMapping("/")
		public String display(Model model) {
			model.addAttribute("question",new Question());
			model.addAttribute("questions",questionService.all());
			return "dashboard";
		}
		
		//add a question
		@RequestMapping("/new")
		public String addQues(@ModelAttribute("addQuestion") Question question,Tag tag) {
			return "newQues";
		}
		
		@PostMapping("/create")
		public String create(@Valid @ModelAttribute("addQuestion") Question question,BindingResult result,@RequestParam("my_tag") String my_tag) {
			System.out.println(question.getQues());
			if (result.hasErrors()) {
		       return "newQues"; 
			}
			else{
				Question q=questionService.create(question);
				List<String> items = (List<String>)Arrays.asList(my_tag.toLowerCase().trim().split("\\s*,\\s*"));
				System.out.println(items);
				ArrayList<Tag> tags=new ArrayList<Tag>();
					for(int i=0;i<items.size();i++) {
						tags.add(tagService.create(items.get(i)));
						
					}
					
					q.setTags(tags);
					questionService.update(q);
					System.out.println(q.getTags()+"*****");
			}	
			
			return "redirect:/"; 
	}
		
		//view selected question
		
		@RequestMapping("/show/{id}")
	    public String findOne(Model model, @PathVariable("id") Long id) {
	        model.addAttribute("question", questionService.findById(id));
	        model.addAttribute("addanswer",new Answer());
	        return "showQues";
	    }
		

			
}
