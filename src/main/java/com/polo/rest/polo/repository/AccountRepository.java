package com.polo.rest.polo.repository;

import org.springframework.data.repository.CrudRepository;
import com.polo.rest.polo.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {

	Account findAccountByCardId(int cardId);
	boolean existsByCardId(int cardId);
	
}
