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

    public void deleteAll() {
        parentRepository.deleteAll();
    }

    public boolean checkParentExistsByEmail( String email ) {
        return parentRepository.existsByEmail( email );
    }

    public List<Parent> getParentsByEmail( String email ) {
        return parentRepository.findAllByEmail( email );
    }

    public void updateFirebaseToken( List<Parent> parentEntiTyList, String firebaseToken ) {
        for ( Parent parent : parentEntiTyList ) {
            parentRepository.updateFirebaseTokenByCardId(parent.getId(), firebaseToken);
        }
    }
	
}
