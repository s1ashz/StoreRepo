package com.polo.rest.polo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.polo.rest.polo.entity.Account;
import com.polo.rest.polo.entity.Parent;
import com.polo.rest.polo.repository.ParentRepository;

@Component
public class ParentDao {

	@Autowired
	private ParentRepository parentRepository;
	
	public void createParent( List<Parent> parentlist ) {
		parentRepository.saveAll( parentlist );
	}
	
	public List<Parent> getParentsByAccount( Account account ) {
		return parentRepository.findByAccount( account );
	}

	public void deleteParents(Account accountEntity) {
		parentRepository.deleteByAccount( accountEntity );
	}
	
}
