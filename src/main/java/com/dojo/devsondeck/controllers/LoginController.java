package com.dojo.devsondeck.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.devsondeck.models.Organization;
import com.dojo.devsondeck.models.User;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {
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
	public String devRegistration(@Valid @ModelAttribute("newDev") User user, BindingResult result, HttpSession session) {
		// TO-DO: Submit Handling
		return "redirect:/devs/skills/languages";
	}
	
	// Org Registration Handling
		@PostMapping("/orgs/register")
		public String orgRegistration(@Valid @ModelAttribute("newOrg") Organization org, BindingResult result, HttpSession session) {
			// TO-DO: Submit Handling
			return "redirect:/orgs/dashboard";
		}
}
