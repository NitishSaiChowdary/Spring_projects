package com.dl.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dl.Dto.AccountDto;
import com.dl.service.AccountService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class AccountController {
	
	AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	
	@PostMapping("/createAccount")
	public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<AccountDto>(accountService.createAccount(accountDto), HttpStatus.CREATED);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> accountGetById(@PathVariable("id") Long id){
		AccountDto accountDto= accountService.accountGetById(id);
		return ResponseEntity.ok(accountDto); 
		
	}
	//Deposit rest api
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable("id") Long id,@RequestBody Map<String,Double> request){ 	
		double amount =request.get("amount");
		AccountDto accountDto = accountService.deposit(id,amount);
		return ResponseEntity.ok(accountDto); 
	}
	
	//withDraw rest api
	@PutMapping("/{id}/withDraw")
	public ResponseEntity<AccountDto> withDraw(@PathVariable("id") Long id , @RequestBody Map<String,Double> request){
		
		
		double amount =request.get("amount");
		AccountDto accountDto = accountService.withDraw(id,amount);
		
		return ResponseEntity.ok(accountDto);
		
	}
	
	
	//GETall rest api
	@GetMapping("/GETALL")
	public ResponseEntity<List<AccountDto>> getAll(){
		List<AccountDto> account = accountService.getAll();
		return ResponseEntity.ok(account);
	}
	
	
	//Delete rest api 
	

	@DeleteMapping("Accountdelete/{id}")
	public void deleteAccount(@PathVariable("id")Long id) {
		accountService.deleteAccount(id);
		
	}
	

}
