package com.dojo.devsondeck.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.devsondeck.models.LoginUser;
import com.dojo.devsondeck.models.Organization;
import com.dojo.devsondeck.models.Position;
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
		session.setAttribute("dev", userServ.findById(newUser.getId()));
		return "redirect:/devs/skills/languages";
	}
	
	// Org Registration Handling
	@PostMapping("/orgs/register")
	public String orgRegistration(@Valid @ModelAttribute("newOrg") Organization newOrg, BindingResult result, HttpSession session) {
		orgServ.register(newOrg, result);
		if(result.hasErrors()) {
			return "OrgRegistration.jsp";
		}
		session.setAttribute("org", orgServ.findById(newOrg.getId()));
		return "redirect:/orgs/dashboard";
	}
		
	// Display Dev Login Page
	@GetMapping("/devs/login")
	public String devLoginPage(Model model) {
		model.addAttribute("newLogin", new LoginUser());
		return "DevLogin.jsp";
	}
	
	// Display Org Login Page
	@GetMapping("/orgs/login")
	public String orgLoginPage(Model model) {
		model.addAttribute("newLogin", new LoginUser());
		return "OrgLogin.jsp";
	}
	
	// Dev Login Handling
	@PostMapping("/devs/login")
	public String devLogin(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = userServ.login(newLogin, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "DevLogin.jsp";
		}
		session.setAttribute("dev", user);
		return "redirect:/devs/dashboard";
	}
	
	// Org Login Handling
	@PostMapping("/orgs/login")
	public String orgLogin(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		Organization org = orgServ.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "OrgLogin.jsp";
		}
		session.setAttribute("org", org);
		return "redirect:/orgs/dashboard";
	}
	
	// Display New Position Form
	@GetMapping("/orgs/jobs/new")
	public String languages(Model model, HttpSession session) {
		model.addAttribute("newPos", new Position());
		return "NewPosition.jsp";
	}
}
