package com.zoya.DojoOverflow.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.zoya.DojoOverflow.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {

	Optional<Question> findById(Long id);

}
