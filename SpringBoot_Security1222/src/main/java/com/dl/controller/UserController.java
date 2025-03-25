package com.dl.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dl.model.Users;
import com.dl.service.UsersService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class UserController {
	@Autowired
	private UsersService usersService;
	
	public UserController(UsersService usersService) {
		super();
		this.usersService = usersService;
	}

    @GetMapping("app/login")
    public ModelAndView loginPage() {
        return new ModelAndView("Login");
    }
    
    @GetMapping("/home")
    public String home() {
    	return "welcome to dashboard";
    }
	//create a new users
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		
		return usersService.register(user);
		
	}
	
	 @PostMapping("/login")
	    public String login(@RequestBody Users user) {

	        return usersService.verify(user);
	    }
	 



}
