package com.zoya.DojoOverflow.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zoya.DojoOverflow.models.Tag;
import com.zoya.DojoOverflow.repositories.TagRepository;

@Service
public class TagService {

private TagRepository tagRepository;
	
	public TagService(TagRepository tagRepository) {
		this.tagRepository=tagRepository;
	}
	
	public ArrayList<Tag> all(){
		return (ArrayList<Tag>) tagRepository.findAll();
	}
	
	public Tag create( String tag) {
		return tagRepository.save(new Tag(tag));
	}
	
	public void destroy(Long id) {
		tagRepository.delete(id);
    }

	public Tag findById(Long id) {
		Optional<Tag> optionalTag = tagRepository.findById(id);
        if (optionalTag.isPresent()){
            return optionalTag.get();
        }else{
            return null;
        }
    }
	
	public void update(Tag tag) {
		tagRepository.save(tag);
    }
	
}
