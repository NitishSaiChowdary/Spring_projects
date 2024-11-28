package com.dl.Dto;

import java.util.List;

import com.dl.model.Model;

public interface ModelRepos {
	
	Model saveModel(Model model);
	
	Model updateModel(Model model);
	
	Model getById(int id);
	
	List<Model> getAllModel();
	
	String deleteById(int id);

}
