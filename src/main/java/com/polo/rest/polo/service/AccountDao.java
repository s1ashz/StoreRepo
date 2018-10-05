package com.polo.rest.polo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.polo.rest.polo.entity.Account;
import com.polo.rest.polo.repository.AccountRepository;

@Component
public class AccountDao {

	@Autowired
	AccountRepository accountRepository;
	
	public Account getAccountByCardId( int cardId ) {
		return accountRepository.findAccountByCardId(cardId);
	}
	
	public void createAccount( Account account ) {
		accountRepository.save( account );
	}
	
}
