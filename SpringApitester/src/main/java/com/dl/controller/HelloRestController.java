package com.dl.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

@RestController
@RequestMapping("/api")
public class HelloRestController {
	
	//get
	@GetMapping("/get")
	public String get(Model model) {
		model.addAttribute("userName", "Sai Kiran");
		model.addAttribute("userEmail", "SaiKiran@gmail.com");
		model.addAttribute("userContact", "9876543210");
		return "userDetails";
	}
	
	//update
	@PutMapping("/put")
	public String put() {
		return "PUT METHOD INVOKED";
	}
	
	//create
	@PostMapping("/post")
	public String post() {
		return "POST METHOD INVOKED";
	}
	
	//delete
	@DeleteMapping("/delete")
	public String delete() {
		return "Delete METHOD INVOKED";
	}
	

}
