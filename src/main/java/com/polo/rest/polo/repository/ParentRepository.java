package com.polo.rest.polo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.polo.rest.polo.entity.Account;
import com.polo.rest.polo.entity.Parent;

public interface ParentRepository extends CrudRepository<Parent, Integer> {

	List<Parent> findByAccount( Account account );
	void  deleteByAccount( Account account );
	boolean existsByEmail( String email );
    List<Parent> findAllByEmail( String email );
    
    @Modifying
    @Query("UPDATE Parent p set p.firebaseToken =:firebaseTokenVar where p.id =:idVar")
    void updateFirebaseTokenByCardId( @Param("idVar") int id, @Param("firebaseTokenVar") String firebaseToken );
	
}
