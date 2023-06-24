package com.dojo.devsondeck.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.dojo.devsondeck.models.LoginUser;
import com.dojo.devsondeck.models.Organization;
import com.dojo.devsondeck.repositories.organizationRepo;

@Service
public class OrganizationService {
	@Autowired
	private organizationRepo orgRepo;
	
	public Organization register(Organization newOrg, BindingResult result) {
		Optional<Organization> emailCheck = orgRepo.findByEmail(newOrg.getEmail());
		if(result.hasErrors()) {
			return null;
		} else {
			if(emailCheck.isPresent()) {
				result.rejectValue("email", "Matches", "Account with email already exists");
				return null;
			} else {
				if(!newOrg.getPassword().equals(newOrg.getConfirmPassword())) {
					result.rejectValue("confirmPassword", "Matches", "Passwords must match");
					return null;
				} else {
					String hashed = BCrypt.hashpw(newOrg.getPassword(), BCrypt.gensalt());
					newOrg.setPassword(hashed);
					orgRepo.save(newOrg);
					return newOrg;
				}
			}
		}
	}
	
	public Organization login(LoginUser newLoginObject, BindingResult result) {
		Optional<Organization> emailCheck = orgRepo.findByEmail(newLoginObject.getEmail());
		if(result.hasErrors()) {
			return null;
		} else {
			if(!emailCheck.isPresent()) {
				result.rejectValue("email", "Matches", "Account with this email does not exist");
				return null;
			} else {
				if(!BCrypt.checkpw(newLoginObject.getPassword(), emailCheck.get().getPassword())) {
					result.rejectValue("password", "Matches", "Invalid Password");
					return null;
				} else {
					return emailCheck.get();
				}
			}
		}
	}
	
	public Organization findById(Long id) {
		Optional<Organization> optOrg = orgRepo.findById(id);
		if(optOrg.isPresent()) {
			return optOrg.get();
		} else {
			return null;
		}
	}
}
