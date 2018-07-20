package com.zoya.DojoOverflow.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zoya.DojoOverflow.models.Answer;
import com.zoya.DojoOverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	
private AnswerRepository answerRepository;
	
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository=answerRepository;
	}
	
	public ArrayList<Answer> all(){
		return (ArrayList<Answer>) answerRepository.findAll();
	}
	
	public Answer create( Answer answer) {
		return answerRepository.save(answer);
	}
	
	public void destroy(Long id) {
		answerRepository.delete(id);
    }

	public Answer findById(Long id) {
		Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if (optionalAnswer.isPresent()){
            return optionalAnswer.get();
        }else{
            return null;
        }
    }
	
	public void update(Answer answer) {
		answerRepository.save(answer);
    }
	
}
