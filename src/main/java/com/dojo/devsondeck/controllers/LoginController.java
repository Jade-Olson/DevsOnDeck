package com.dojo.devsondeck.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.devsondeck.models.Organization;
import com.dojo.devsondeck.models.User;
import com.dojo.devsondeck.services.OrganizationService;
import com.dojo.devsondeck.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {
	@Autowired
	private UserService userServ;
	@Autowired
	private OrganizationService orgServ;
	// Display Dev Registration Page
	@GetMapping("/devs/register")
	public String devRegistrationPage(Model model) {
		model.addAttribute("newDev", new User());
		return "DevRegistration.jsp";
	}
	
	// Display Org Registration Page
	@GetMapping("/orgs/register")
	public String orgRegistrationPage(Model model) {
		model.addAttribute("newOrg", new Organization());
		return "OrgRegistration.jsp";
	}
	
	// Dev Registration Handling
	@PostMapping("/devs/register")
	public String devRegistration(@Valid @ModelAttribute("newDev") User newUser, BindingResult result, HttpSession session) {
		userServ.register(newUser, result);
		if(result.hasErrors()) {
			return "DevRegistration.jsp";
		}
		session.setAttribute("dev", newUser);
		return "redirect:/devs/skills/languages";
	}
	
	// Org Registration Handling
		@PostMapping("/orgs/register")
		public String orgRegistration(@Valid @ModelAttribute("newOrg") Organization newOrg, BindingResult result, HttpSession session) {
			orgServ.register(newOrg, result);
			if(result.hasErrors()) {
				return "OrgRegistration.jsp";
			}
			session.setAttribute("org", newOrg);
			return "redirect:/orgs/dashboard";
		}
}
