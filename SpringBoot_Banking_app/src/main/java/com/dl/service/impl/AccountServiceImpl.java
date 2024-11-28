package com.dl.service.impl;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.dl.Dto.AccountDto;
import com.dl.Model.AccountModel;
import com.dl.Repository.AccountRepository;
import com.dl.mapper.AccountMapper;
import com.dl.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {
	
	AccountRepository accountRepository;
	

	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}


	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		AccountModel accountModel = AccountMapper.mapToAccountModel(accountDto) ;
		AccountModel savedAccount = accountRepository.save(accountModel);
		return AccountMapper.mapTOAccountDto(savedAccount);
	}


	@Override
	public AccountDto accountGetById(Long id) {
		AccountModel account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exit"));
		return AccountMapper.mapTOAccountDto(account);
	}


	@Override
	public List<AccountDto> getAll() {
		List<AccountModel> account =accountRepository.findAll();
		return	account.stream().map((accountModel)->AccountMapper.mapTOAccountDto(accountModel))
		.collect(Collectors.toList());
		 
	}


	@Override
	public AccountDto deposit(Long id, double amount) {
		AccountModel account1 = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exit"));
		double total = account1.getAccountBlanace() + amount;
		account1.setAccountBlanace(total);
		AccountModel savedAccount1=accountRepository.save(account1);
		return AccountMapper.mapTOAccountDto(savedAccount1);
	}


	@Override
	public AccountDto withDraw(Long id, double amount) {
		AccountModel account2 = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exit"));
		if(account2.getAccountBlanace() < amount) {
			throw new RuntimeException("Insufficient Balance");
		}
		double total1 = account2.getAccountBlanace() - amount;
		account2.setAccountBlanace(total1);
		AccountModel SaveAccount2 =  accountRepository.save(account2);
		
		
		return AccountMapper.mapTOAccountDto(SaveAccount2);
	}


	@Override
	public void deleteAccount(Long id) {
		AccountModel account3 = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exit"));
		
		accountRepository.deleteById(id);
		
	}
	
	
	
	

}
