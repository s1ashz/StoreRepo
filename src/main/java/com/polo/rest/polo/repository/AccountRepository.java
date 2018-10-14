package com.polo.rest.polo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.polo.rest.polo.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {

	Account findAccountByCardId(int cardId);
	boolean existsByCardId(int cardId);
	
	@Query("SELECT a.level FROM Account a WHERE a.cardId =:cardIdVar")
	String findLevelByCardId(@Param("cardIdVar") int cardId );
	
}
