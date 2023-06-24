package com.dojo.devsondeck.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.dojo.devsondeck.models.LoginUser;
import com.dojo.devsondeck.models.User;
import com.dojo.devsondeck.repositories.userRepo;

@Service
public class UserService {
	@Autowired
	private userRepo userRepo;
	
	public User register(User newUser, BindingResult result) {
		Optional<User> emailCheck = userRepo.findByEmail(newUser.getEmail());
		if(result.hasErrors()) {
			return null;
		} else {
			if(emailCheck.isPresent()) {
				result.rejectValue("email", "Matches", "Account with email already exists");
				return null;
			} else {
				if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
					result.rejectValue("confirmPassword", "Matches", "Passwords must match");;
					return null;
				} else {
					String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
					newUser.setPassword(hashed);
					userRepo.save(newUser);
					return newUser;
				}
			}
		}
	}
	
	public User login(LoginUser newLoginObject, BindingResult result) {
		Optional<User> emailCheck = userRepo.findByEmail(newLoginObject.getEmail());
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
	
	public User findById(Long id) {
		Optional<User> optUser = userRepo.findById(id);
		if(optUser.isPresent()) {
			return optUser.get();
		} else {
			return null;
		}
	}
}
