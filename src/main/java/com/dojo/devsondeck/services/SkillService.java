package com.dojo.devsondeck.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dojo.devsondeck.models.Skill;
import com.dojo.devsondeck.repositories.SkillsRepo;



@Service
public class SkillService {

	@Autowired
	private SkillsRepo SkillRepo;
	
	
	public Skill AddSkill(Skill skill) {
		return SkillRepo.save(skill);
	}
	
	public void DeleteSkill(Long id) {
		
		SkillRepo.deleteById(id);
	}
	
	public List<Skill> AllSkills(){
		
		return SkillRepo.findAll();
	}
}
