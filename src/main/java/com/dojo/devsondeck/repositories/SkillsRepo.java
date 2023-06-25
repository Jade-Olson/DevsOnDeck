package com.dojo.devsondeck.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.dojo.devsondeck.models.Skill;


@Repository
public interface SkillsRepo extends CrudRepository<Skill,Long>{
	
	List<Skill> findAll();

}
