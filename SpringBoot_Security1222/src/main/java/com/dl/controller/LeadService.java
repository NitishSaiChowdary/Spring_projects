package com.dl.controller;

import java.util.List;
import java.util.Optional;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.model.LeadModel;
import com.dl.repo.LeadRepo;


@Service
public class LeadService {

	@Autowired
	LeadRepo repo;

	public LeadService(LeadRepo repo) {
		super();
		this.repo = repo;
	}
	
    public List<LeadModel> createEmployees(List<LeadModel> leadModel) {
        return repo.saveAll(leadModel); // Save a list of employees
    }
    
	
	public LeadModel createEmp(LeadModel leadModel) {
		return repo.save(leadModel);
	}
	
	public List<LeadModel> getEmployees(){
		return repo.findAll();	
	}
	
	public Optional<LeadModel> getLeadById(int id) {
		return repo.findById(id);
	} 
}
