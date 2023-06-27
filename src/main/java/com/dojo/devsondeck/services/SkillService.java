package com.dojo.devsondeck.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dojo.devsondeck.models.Skill;
import com.dojo.devsondeck.models.User;
import com.dojo.devsondeck.repositories.SkillsRepo;
import com.dojo.devsondeck.repositories.userRepo;



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
	
    public Skill findById(Long id) {
		Optional<Skill> optSkill = SkillRepo.findById(id);
		if(optSkill.isPresent()) {
			return optSkill.get();
		} else {
			return null;
		}
}
}