package com.dl.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Model {
	@Id
	
	private int id;
	
	private String fname;
	
	private String lname;
	
	private String email;

}
