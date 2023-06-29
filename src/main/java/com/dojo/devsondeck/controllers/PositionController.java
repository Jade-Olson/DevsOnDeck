package com.dojo.devsondeck.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dojo.devsondeck.models.Organization;
import com.dojo.devsondeck.models.Position;
import com.dojo.devsondeck.models.PositionNeededSkills;
import com.dojo.devsondeck.models.Skill;
import com.dojo.devsondeck.services.OrganizationService;
import com.dojo.devsondeck.services.PositionService;
import com.dojo.devsondeck.services.SkillService;
import com.dojo.devsondeck.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PositionController {
	
	@Autowired
	private PositionService positionServ;
	@Autowired
	private SkillService skillServ;
	@Autowired
	private OrganizationService orgServ;
	@Autowired
	private UserService userServ;
	
	// Org Dashboard render
	@GetMapping("/orgs/dashboard")
	public String dashboard(Model model, HttpSession session) {
		model.addAttribute("allPositions", positionServ.AllPositions());
		model.addAttribute("devs", userServ.allUsers());
		return "OrgDashboard.jsp";
	}
	
	// Display New Position Form
	@GetMapping("/orgs/jobs/new")
	public String languages(Model model, HttpSession session) {
		if (session.getAttribute("org") == null) {
			return "redirect:/orgs/login";
		}
		model.addAttribute("newPos", new Position());
		List<Skill> skill = skillServ.AllSkills();
		model.addAttribute("skills",skill);
		model.addAttribute("newPos",new Position());
		return "NewPosition.jsp";
	}
	
	@PostMapping("/orgs/jobs/add/position")
	public String addPosition(@Valid @ModelAttribute("newPos") Position newPosition, BindingResult result, HttpSession session, @RequestParam("skills") List<Long> skillIds
		   ,Model model) {
		List<PositionNeededSkills> positionSkills = new ArrayList<>();
		List<Skill> skill = skillServ.AllSkills();
	    if (result.hasErrors()) {
	    	 
	 		model.addAttribute("skills",skill);
	        return "NewPosition.jsp";
	    }
	    Organization org = (Organization) session.getAttribute("org");
	    newPosition.setOrganization(orgServ.findById(org.getId()));
	    positionServ.AddPosition(newPosition);
	    
	    PositionNeededSkills positionSkill = new PositionNeededSkills();
	    
	    positionSkill.setPositions(newPosition);
	    
	    for(Long skillId : skillIds) {
	    	
	    	Skill skills = skillServ.findById(skillId);
	    	positionSkill.setSkills(skills);
	    	skillServ.AddSkill(skills);
	    	
	    }
	    

	    return "redirect:/orgs/dashboard";
	}	
}
