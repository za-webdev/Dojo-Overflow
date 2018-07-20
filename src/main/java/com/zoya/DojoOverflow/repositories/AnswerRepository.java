package com.zoya.DojoOverflow.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.zoya.DojoOverflow.models.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

	Optional<Answer> findById(Long id);

}
