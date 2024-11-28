package com.dl.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
//DTO is used in Spring Boot applications for managing data transfer efficiently
@Data
@AllArgsConstructor
public class AccountDto {
	
	private Long id;
	
	private String accountHolderName;
	
	private Double accountBlanace;

}
