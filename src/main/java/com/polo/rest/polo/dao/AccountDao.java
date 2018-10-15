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

	public boolean checkAccountExists(int cardId) {
		return accountRepository.existsByCardId( cardId );
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

    public String getAccountLevelByCardId( int cardId ) {
        return accountRepository.findLevelByCardId( cardId );
    }

	public void deleteAccount(Account account) {
		accountRepository.delete(account);
	}

    public boolean checkAccountExistsByEmail( String email ) {
        return accountRepository.existsByEmail( email );
    }

    public void updateFirebaseToken( int cardId, String firebaseToken ) {
        accountRepository.updateFirebaseTokenByCardId(cardId, firebaseToken);
        
    }
}
