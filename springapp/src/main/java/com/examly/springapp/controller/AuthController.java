package com.examly.springapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.dao.IUserModel;
import com.examly.springapp.model.LoginModel;
import com.examly.springapp.model.UserModel;

@RestController
public class AuthController {

	@Autowired
	IUserModel iUserModel;
	
	@PostMapping("/login")
	public boolean login(@RequestBody LoginModel model) {
		try {
			Optional<UserModel> userModel= iUserModel.findById(model.getEmail());
			if(userModel.isEmpty()) return false;
			if(!userModel.get().getPassword().equals(model.getPassword())) return false;
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	@PostMapping("/signup")
	public boolean signup(@RequestBody UserModel model) {
		try {
			iUserModel.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
