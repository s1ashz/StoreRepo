package com.polo.rest.polo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.polo.rest.polo.entity.Account;
import com.polo.rest.polo.entity.Parent;

public interface ParentRepository extends CrudRepository<Parent, Integer> {

	List<Parent> findByAccount( Account account );
	void  deleteByAccount( Account account );
	boolean existsByEmail( String email );
    List<Parent> findAllByEmail( String email );
	
}
