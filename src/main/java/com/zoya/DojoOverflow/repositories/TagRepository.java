package com.zoya.DojoOverflow.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.zoya.DojoOverflow.models.Tag;

public interface TagRepository extends CrudRepository<Tag,Long> {

	Optional<Tag> findById(Long id);

	Tag save(String tag);

}
