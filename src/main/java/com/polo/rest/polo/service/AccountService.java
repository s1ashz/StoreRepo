package com.polo.rest.polo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.polo.rest.polo.dao.AccountDao;
import com.polo.rest.polo.dao.ParentDao;
import com.polo.rest.polo.dto.AccountDto;
import com.polo.rest.polo.dto.ConvertionManager;
import com.polo.rest.polo.dto.ParentsDto;
import com.polo.rest.polo.entity.Account;
import com.polo.rest.polo.entity.Parent;
import com.polo.rest.polo.exceptions.AccountException;
import com.polo.rest.polo.validators.AccountValidator;

import static com.polo.rest.polo.constants.ExceptionMessages.*;

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountValidator accountValidator;
    
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private ParentDao parentDao;
	
	private ConvertionManager convertionManagerInstance;
	
	private final String CREATE = "create";
	private final String UPDATE = "update";
	private final String DELETE = "delete";

	
	public AccountService() {
		convertionManagerInstance = ConvertionManager.getConvertionManager();
	}
	
	public void createAccount( AccountDto accountDto ) throws AccountException {
		accountValidator.validateAccount(accountDto);
		Account accountEntity = convertionManagerInstance.convertAccountToEntity( accountDto );
		checkAccountExists(accountEntity, CREATE);
		accountDao.createAccount( accountEntity );
		List<Parent> parentsEntityList = convertionManagerInstance.convertParentsDtoToEntity( accountDto.getParents(), accountEntity );
		parentDao.createParent( parentsEntityList );
	}
	
	public AccountDto getAccountByCardId( int cardId ) throws AccountException {
		Account accountEntity = accountDao.getAccountByCardId(cardId);
		if ( null == accountEntity ) throw new AccountException(EXCEPTION_ACCOUNT_NOT_EXISTS + cardId);
		List<Parent> parentList = parentDao.getParentsByAccount( accountEntity );
		
		AccountDto accountDto = convertionManagerInstance.convertAccountToDto( accountEntity );
		List<ParentsDto> parentDtoList = convertionManagerInstance.convertParentsToDto( parentList );
		accountDto.setParents( parentDtoList );
		
		return accountDto;
	}

	public List<AccountDto> getAllAccounts() {
		List<Account> accountEntityList = accountDao.getAllAccounts();
		List<AccountDto> accountDtoList = convertAccountEntityToDtoListWithParents(accountEntityList);
		return accountDtoList;
	}

	public void updateAccount(AccountDto accountDto) throws AccountException {
		accountValidator.validateAccount( accountDto );
		Account accountEntity = convertionManagerInstance.convertAccountToEntity( accountDto );
		checkAccountExists( accountEntity, UPDATE );
		
		Account oldAccountEntity = accountDao.getAccountByCardId( accountEntity.getCardId() );
		accountEntity.setId( oldAccountEntity.getId() );
		parentDao.deleteParents( accountEntity );
		
		List<Parent> parentEntityList = convertionManagerInstance.convertParentsDtoToEntity( accountDto.getParents(), accountEntity );
		
		parentDao.createParent(parentEntityList);
		accountDao.updateAccount( accountEntity );
	}
	
	private List<AccountDto> convertAccountEntityToDtoListWithParents(List<Account> accountEntityList) {
		List<AccountDto> accountDtoList = new ArrayList<>();
		for ( Account acc : accountEntityList ) {
			List<Parent> parentEntityList = parentDao.getParentsByAccount(acc);
			List<ParentsDto> parentDtoList = convertionManagerInstance.convertParentsToDto( parentEntityList );
			AccountDto accountDto = convertionManagerInstance.convertAccountToDto(acc);
			accountDto.setParents( parentDtoList );
			accountDtoList.add(accountDto);
		}
		return accountDtoList;
	}

	private void checkAccountExists( Account accountEntity, String action ) throws AccountException {
		boolean exists = accountDao.checkAccountExists(accountEntity);
		switch ( action ) {
		case CREATE:
			if ( exists ) throw new AccountException( EXCEPTION_ACCOUNT_ALREAD_EXISTS + accountEntity.getCardId() );
			break;
		case UPDATE:
			if ( !exists ) throw new AccountException( EXCEPTION_ACCOUNT_NOT_EXISTS + accountEntity.getCardId() );
			break;
		case DELETE:
			if ( !exists ) throw new AccountException( EXCEPTION_ACCOUNT_NOT_EXISTS + accountEntity.getCardId() );
			break;
		default:
			break;
		}
	}

    public void deleteAll() {
        parentDao.deleteAll();
        accountDao.deleteAll();
    }

	
}
