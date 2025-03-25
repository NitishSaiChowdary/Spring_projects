package com.dl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dl.model.LeadModel;



@RestController
@RequestMapping()
public class LeadController {
	@Autowired
	LeadService leadService;

	public LeadController(LeadService leadService) {
		super();
		this.leadService = leadService;
	}
	
	//create a single employee
		@PostMapping("/single")
		public ResponseEntity<LeadModel> saveEmployee(@RequestBody LeadModel leadModel){
			return new ResponseEntity<LeadModel>(leadService.createEmp(leadModel), HttpStatus.CREATED);
		}
		//create a multiple employess
		@PostMapping("/create")
	    public ResponseEntity<List<LeadModel>> createEmployees(@RequestBody List<LeadModel> leadModel) {
	        List<LeadModel> createdEmps = leadService.createEmployees(leadModel);
	        return ResponseEntity.ok(createdEmps);
	    }
		@GetMapping("/all")
		public List<LeadModel> getall(){
			return leadService.getEmployees();
			
		}
		
		@GetMapping("/{id}")
		public  Optional<LeadModel> getLeadById(@PathVariable("id")int id) {
			return leadService.getLeadById(id);
		} 
		

}
