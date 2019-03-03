package com.polo.rest.polo.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.polo.rest.polo.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {

	Account findAccountByCardId(int cardId);
	boolean existsByCardId(int cardId);
	boolean existsByEmail( String email );
	void deleteByCardId( int cardId );
	
	List<Account> findByCardIdIn(List<Integer> cardIdList);
	
	@Query("SELECT a.level FROM Account a WHERE a.cardId =:cardIdVar")
	String findLevelByCardId( @Param("cardIdVar") int cardId );

	@Modifying
	@Query("UPDATE Account acc set acc.token =:firebaseTokenVar where acc.cardId =:cardIdVar")
	void updateFirebaseTokenByCardId( @Param("cardIdVar") int cardId, @Param("firebaseTokenVar") String firebaseToken );
	
	@Modifying
    @Query("SELECT DISTINCT acc.token FROM Account acc WHERE acc.level =:levelVar")
    List<String> getAccountTokenByLevel( @Param("levelVar") String level );
	
}
