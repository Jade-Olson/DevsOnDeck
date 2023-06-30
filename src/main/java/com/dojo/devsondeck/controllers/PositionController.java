package com.dojo.devsondeck.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		if (session.getAttribute("org") == null) {
			return "redirect:/orgs/login";
		}
		model.addAttribute("allPositions", positionServ.AllPositions());
		model.addAttribute("devs", userServ.allUsers());
		return "orgDashboard.jsp";
	}
	
	 @DeleteMapping("/orgs/delete/{id}")
	    public String destroy(@PathVariable("id") Long id,HttpSession session) {
		 if (session.getAttribute("org") == null) {
				return "redirect:/orgs/login";
			}
		 positionServ.delete(id);
	        return "redirect:/orgs/dashboard";
	    }
	 
	 @GetMapping("/orgs/{id}/edit")
		public String edit(@PathVariable("id") Long id, Model model,HttpSession session) {
			if (session.getAttribute("org") == null) {
				return "redirect:/orgs/login";
			}
			
			Position position = positionServ.findById(id);
			model.addAttribute("position", position);
			return "EditPos.jsp";
		}
	 
	    @RequestMapping(value="/postition/{id}", method=RequestMethod.PUT)
	    public String edit(@PathVariable("id") Long id,@Valid @ModelAttribute("position") Position position, BindingResult result, HttpSession session
	 		   ,Model model) {
	    	 Organization org = (Organization) session.getAttribute("org");
	    	if (session.getAttribute("org") == null) {
				return "redirect:/orgs/login";
			}
	    	if (result.hasErrors()) {
		    	 
		        return "EditPos.jsp";
		    }
	    	position.setId(id);
	    	position.setOrganization(org);
	    	positionServ.AddPosition(position);
	    	return"redirect:/orgs/dashboard";
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
	public String addPosition(@Valid @ModelAttribute("newPos") Position newPosition, BindingResult result, HttpSession session
		   ,Model model) {
		if (session.getAttribute("org") == null) {
			return "redirect:/orgs/login";
		}
		List<PositionNeededSkills> positionSkills = new ArrayList<>();
		List<Skill> skill = skillServ.AllSkills();
	    if (result.hasErrors()) {
	    	 
	 		model.addAttribute("skills",skill);
	        return "NewPosition.jsp";
	    }
	    Organization org = (Organization) session.getAttribute("org");
	    newPosition.setOrganization(orgServ.findById(org.getId()));
	    positionServ.AddPosition(newPosition);
	    
	  
	    return "redirect:/orgs/dashboard";
	}	
}
