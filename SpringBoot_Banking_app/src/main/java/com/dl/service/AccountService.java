package com.dl.service;

import java.util.List;

import com.dl.Dto.AccountDto;


public interface AccountService {
	
	AccountDto createAccount(AccountDto accountdto);
	
	AccountDto accountGetById(Long id );
	
	List<AccountDto> getAll();
	
	AccountDto deposit(Long id,double amount);
	
	AccountDto withDraw(Long id,double amount);
	
	void deleteAccount(Long id);
	

}
