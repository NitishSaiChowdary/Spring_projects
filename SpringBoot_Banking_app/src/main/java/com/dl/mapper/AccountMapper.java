package com.dl.mapper;

import com.dl.Dto.AccountDto;
import com.dl.Model.AccountModel;
// MAPPER is a Java library that helps in mapping objects from one model to another, reducing the need for manual mapping code.

// Account dto to jpa entity and converting jpa entity to account dto 
public class AccountMapper {
	
	public static AccountModel mapToAccountModel(AccountDto accountDto) {
		
		AccountModel accountModel = new  AccountModel(
				accountDto.getId(),
				accountDto.getAccountHolderName(),
				accountDto.getAccountBlanace()	
				);
		return accountModel;
		
	}
	
	public static AccountDto mapTOAccountDto(AccountModel accountModel) {
		
		AccountDto accountDto = new AccountDto(
				accountModel.getId(),
				accountModel.getAccountHolderName(),
				accountModel.getAccountBlanace());
		return accountDto;
		
	}

}
