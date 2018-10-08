package com.polo.rest.polo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.polo.rest.polo.entity.Account;
import com.polo.rest.polo.repository.AccountRepository;

@Repository
public class AccountDao {

	@Autowired
	AccountRepository accountRepository;
	
	public Account getAccountByCardId( int cardId ) {
		return accountRepository.findAccountByCardId(cardId);
	}
	
	public void createAccount( Account account ) {
		accountRepository.save( account );
	}

	public boolean checkAccountExists(Account accountEntity) {
		return accountRepository.existsByCardId( accountEntity.getCardId() );
	}
	
	public List<Account> getAllAccounts() {
		return (List<Account>) accountRepository.findAll();
	}

	public void updateAccount(Account accountEntity) {
		accountRepository.save( accountEntity );
	}

    public void deleteAll() {
        accountRepository.deleteAll();
    }
}
