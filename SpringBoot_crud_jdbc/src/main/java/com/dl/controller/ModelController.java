package com.dl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dl.Dto.ModelRepos;
import com.dl.model.Model;

@RestController
@RequestMapping("/api")
public class ModelController {
	@Autowired
	ModelRepos modelRepos;
	@PostMapping("/createModel")
	public Model saveModel(@RequestBody Model model) {
		return modelRepos.saveModel(model);
	}

	@PutMapping("/updateModel")
	public Model updateModel(Model model) {
		return modelRepos.updateModel(model);
	}
	
	@GetMapping("/getById/{id}")
	public Model getById(@PathVariable("id")int id) {
		return modelRepos.getById(id);
	}
	
	
	@GetMapping("/getAllModel")
	public List<Model> getAllModel(){
		return modelRepos.getAllModel();
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable("id")int id) {
		return modelRepos.deleteById(id);
		
	}
	

}
