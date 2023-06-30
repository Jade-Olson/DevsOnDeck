package com.dojo.devsondeck.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import com.dojo.devsondeck.models.Skill;
import com.dojo.devsondeck.models.User;
import com.dojo.devsondeck.models.UserHasSkills;
import com.dojo.devsondeck.services.SkillService;
import com.dojo.devsondeck.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class SkillsControllers {
	@Autowired
	private UserService userServ;
	@Autowired
	private SkillService skillServ;
	
	@GetMapping("/devs/skills/languages")
	public String Skills(HttpSession session, Model model) {
		if (session.getAttribute("dev") == null) {
			return "redirect:/devs/login";
		}
		List<Skill> skills = skillServ.AllSkills();
		model.addAttribute("skills",skills);
		return "LanguagesForm.jsp";	
	}
	
	// POST for submission of languages page
	@PostMapping("/devs/skills/languages")
	public String langSubmit(@RequestParam("bio") String bio, HttpSession session, Model model) {
		if (session.getAttribute("dev") == null) {
			return "redirect:/devs/login";
		}
		User dev = (User) session.getAttribute("dev");
		dev.setBio(bio);
		
		// TO-DO SET SKILLS TO USER
		
		userServ.update(dev);
		return "redirect:/devs/skills/frameworks";
	}
	
//	// Used for both languages an frameworks and it will render if the type is right in the jsp page
	@GetMapping("/skills/addLanguage/{id}")
	private String addLanguage(HttpSession session, @PathVariable("id") Long id) {
		if (session.getAttribute("dev") == null) {
			return "redirect:/devs/login";
		}
		
	User user = (User) session.getAttribute("dev");
	User loggedUser = userServ.findById(user.getId());
	Skill addedSkill = skillServ.findById(id);
	UserHasSkills userSkills = new UserHasSkills();
	userSkills.setUsers(loggedUser);
	userSkills.setSkills(addedSkill);
	addedSkill.getUsers().add(userSkills);
	skillServ.AddSkill(addedSkill);
	
		return "redirect:/devs/skills/languages";
	
	}
	
	@GetMapping("/devs/skills/frameworks")
	public String FrameWorks(HttpSession session, Model model) {
		if (session.getAttribute("dev") == null) {
			return "redirect:/devs/login";
		}
		List<Skill> skill = skillServ.AllSkills();
		model.addAttribute("skills",skill);
		User userId = (User)session.getAttribute("dev");
		User loggedUser = userServ.findById(userId.getId());
		model.addAttribute("user",loggedUser);
		
		return "FrameWorks.jsp";	
	}
	
	//POST for submission of framework skills page
	@PostMapping("/devs/skills/frameworks")
	public String frameworkSubmit(HttpSession session, Model model) {
		if (session.getAttribute("dev") == null) {
			return "redirect:/devs/login";
		}
		User dev = (User) session.getAttribute("dev");
		
		// TO-DO SET SKILLS TO USER
		
		userServ.update(dev);
		return "redirect:/devs/dashboard";
	}
	
	@GetMapping("/skills/addFrameWork/{id}")
	private String addFrameWork(HttpSession session, @PathVariable("id") Long id) {
		if (session.getAttribute("dev") == null) {
			return "redirect:/devs/login";
		}
		
		User user = (User) session.getAttribute("dev");
		User loggedUser = userServ.findById(user.getId());
		Skill addedSkill = skillServ.findById(id);
		UserHasSkills userSkills = new UserHasSkills();
		userSkills.setUsers(loggedUser);
		userSkills.setSkills(addedSkill);
		addedSkill.getUsers().add(userSkills);
		skillServ.AddSkill(addedSkill);
		
		return "redirect:/devs/skills/frameworks";
		
	}
	
}
