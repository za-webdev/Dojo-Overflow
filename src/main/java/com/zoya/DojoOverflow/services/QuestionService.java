package com.zoya.DojoOverflow.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zoya.DojoOverflow.models.Question;
import com.zoya.DojoOverflow.repositories.QuestionRepository;



@Service
public class QuestionService {
	
private QuestionRepository questionRepository;
	
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository=questionRepository;
	}
	
	public ArrayList<Question> all(){
		return (ArrayList<Question>) questionRepository.findAll();
	}
	
	public Question create( Question question) {
		return questionRepository.save(question);
	}
	
	public void destroy(Long id) {
		questionRepository.delete(id);
    }

	public Question findById(Long id) {
		Optional<Question> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isPresent()){
            return optionalQuestion.get();
        }else{
            return null;
        }
    }
	
	public void update(Question question) {
		questionRepository.save(question);
    }
	
}
