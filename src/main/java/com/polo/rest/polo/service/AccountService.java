package com.polo.rest.polo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.polo.rest.polo.dao.AccountDao;
import com.polo.rest.polo.dao.ParentDao;
import com.polo.rest.polo.dao.PaymentDao;
import com.polo.rest.polo.dto.AccountDto;
import com.polo.rest.polo.dto.ConvertionManager;
import com.polo.rest.polo.dto.ParentsDto;
import com.polo.rest.polo.entity.Account;
import com.polo.rest.polo.entity.Parent;
import com.polo.rest.polo.exceptions.AccountException;
import com.polo.rest.polo.responses.AuthenticationJson;
import com.polo.rest.polo.responses.ResponseJson;
import com.polo.rest.polo.validators.AccountValidator;

import static com.polo.rest.polo.constants.ExceptionMessages.*;

import static com.polo.rest.polo.constants.Actions.*;

@Service
@Transactional
public class AccountService {

    private static final String PARENT = "PARENT";
    private static final String ACCOUNT = "ACCOUNT";

    @Autowired
    private AccountValidator accountValidator;
    
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private ParentDao parentDao;
	
	@Autowired
    private PaymentDao paymentDao;
	
	private ConvertionManager convertionManagerInstance;
	
	public AccountService() {
		convertionManagerInstance = ConvertionManager.getConvertionManager();
	}
	
	public ResponseJson createAccount( AccountDto accountDto ) throws AccountException {
		accountValidator.validateAccount(accountDto);
		Account accountEntity = convertionManagerInstance.convertAccountToEntity( accountDto );
		checkAccountExists(accountEntity.getCardId(), CREATE);
		accountDao.createAccount( accountEntity );
		List<Parent> parentsEntityList = convertionManagerInstance.convertParentsDtoToEntity( accountDto.getParents(), accountEntity );
		parentDao.createParent( parentsEntityList );
		
		return new ResponseJson(CREATE, true);
	}
	
	public AccountDto getAccountByCardId( int cardId ) throws AccountException {
		Account accountEntity = accountDao.getAccountByCardId(cardId);
		if ( null == accountEntity ) throw new AccountException(EXCEPTION_ACCOUNT_NOT_EXISTS + cardId);
		List<Parent> parentList = parentDao.getParentsByAccount( accountEntity );
		
		AccountDto accountDto = convertionManagerInstance.convertAccountToDto( accountEntity );
		List<ParentsDto> parentDtoList = convertionManagerInstance.convertParentsToDto( parentList );
		accountDto.setParents( parentDtoList );
		
		//TODO years list
		
		List<Integer> yearList = paymentDao.getPaymentYearsList(cardId);
		accountDto.setYearsPaid( yearList );
		
		return accountDto;
	}

	public List<AccountDto> getAllAccounts() {
		List<Account> accountEntityList = accountDao.getAllAccounts();
		List<AccountDto> accountDtoList = convertAccountEntityToDtoListWithParents(accountEntityList);
		return accountDtoList;
	}

	public ResponseJson updateAccount(AccountDto accountDto) throws AccountException {
		accountValidator.validateAccount( accountDto );
		Account accountEntity = convertionManagerInstance.convertAccountToEntity( accountDto );
		checkAccountExists( accountEntity.getCardId(), UPDATE );
		
		Account oldAccountEntity = accountDao.getAccountByCardId( accountEntity.getCardId() );
		accountEntity.setId( oldAccountEntity.getId() );
		parentDao.deleteParents( accountEntity );
		
		List<Parent> parentEntityList = convertionManagerInstance.convertParentsDtoToEntity( accountDto.getParents(), accountEntity );
		
		parentDao.createParent(parentEntityList);
		accountDao.updateAccount( accountEntity );
		
		return new ResponseJson( UPDATE, true );
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

    public void deleteAll() {
        parentDao.deleteAll();
        accountDao.deleteAll();
    }

	public ResponseJson deleteAccount(int cardId) throws AccountException {
		checkAccountExists( cardId, DELETE );
		//TODO REMOVE THE EXTRA DATABASE CALL : getAccountByCardId
		Account existingAccount = accountDao.getAccountByCardId( cardId );
		parentDao.deleteParents(existingAccount);
		accountDao.deleteAccount( existingAccount );
		return new ResponseJson(DELETE, true);
	}

	
	//TODO CONTINUE AUTH
	public ResponseJson authenticateAccount( AuthenticationJson auth ) throws AccountException {
		
		System.out.println("auth.getCardId(): " + auth.getCardId());
		System.out.println("auth.getEmail(): " + auth.getEmail());
		System.out.println("auth.getFirebaseToken(): " + auth.getToken());
		
	    Account accountEntity = null;
	    List<Parent> parentEntiTyList = null;
	    
	    Map<String, Boolean> table = new HashMap<>();;
	    checkEmailExists( auth.getEmail(), table );
	    checkCardIdExists( auth.getCardId() );
	    
	    if ( table.containsKey( ACCOUNT ) ) accountEntity = accountDao.getAccountByCardId( auth.getCardId() );
	    if ( table.containsKey( PARENT ) ) parentEntiTyList = parentDao.getParentsByEmail( auth.getEmail() );
	    
	    validateLogin( accountEntity, parentEntiTyList, auth );
	    updateFirebaseToken( accountEntity, parentEntiTyList, auth );
	    
		return new ResponseJson( AUTHENTICATE, true );
	}

    private void updateFirebaseToken( Account accountEntity, List<Parent> parentEntiTyList, AuthenticationJson auth ) {
        if ( null != accountEntity ) accountDao.updateFirebaseToken( accountEntity.getCardId(), auth.getToken() );
        if ( null != parentEntiTyList ) parentDao.updateFirebaseToken( parentEntiTyList, auth.getToken() );
    }

    private void validateLogin( Account accountEntity, List<Parent> parentEntiTyList, AuthenticationJson auth ) throws AccountException {
        if ( validateLoginAccount( accountEntity, auth ) ) return;
        if ( validateLoginParent( parentEntiTyList, auth ) ) return;
        throw new AccountException( EXCEPTION_INVALID_LOGIN );
    }

    private boolean validateLoginParent( List<Parent> parentEntiTyList, AuthenticationJson auth ) {
        return ( null != parentEntiTyList ) ? validateLoginParentData( parentEntiTyList, auth ) : false;
    }

    private boolean validateLoginAccount( Account accountEntity, AuthenticationJson auth ) throws AccountException {
        return ( null != accountEntity ) ? validateLoginAccountData( accountEntity, auth ) : false;
    }

    private boolean validateLoginParentData( List<Parent> parentEntiTyList, AuthenticationJson auth ) {
        for ( Parent parent : parentEntiTyList ) {
            if ( validateEmail( parent.getEmail(), auth.getEmail() ) && validateCardId ( parent.getAccount().getCardId(), auth.getCardId() ) ) {
                return true;
            }
        }
        return false;
    }

    private boolean validateLoginAccountData( Account accountEntity, AuthenticationJson auth ) throws AccountException {
        if ( !validateEmail( accountEntity.getEmail(), auth.getEmail() ) ) throw new AccountException( EXCEPTION_INVALID_EMAIL + auth.getEmail() );
        if ( !validateCardId( accountEntity.getCardId(), auth.getCardId() ) ) throw new AccountException( EXCEPTION_INVALID_CARD_ID + auth.getCardId() );
        return true;
    }

    private boolean validateEmail( String emailDatabase, String authEmail ) {
        return emailDatabase.equals( authEmail );
    }

    private boolean validateCardId( int cardIdDatabase, int authCardId ) {
        return cardIdDatabase == authCardId;
    }

    private void checkCardIdExists( int cardId ) throws AccountException {
	    if ( !accountDao.checkAccountExists( cardId ) ) throw new AccountException( EXCEPTION_ACCOUNT_NOT_EXISTS + cardId );
    }

    private Map<String, Boolean> checkEmailExists( String email, Map<String, Boolean> table ) throws AccountException {
	    if ( accountDao.checkAccountExistsByEmail( email ) ) table.put( ACCOUNT, true );
	    if ( parentDao.checkParentExistsByEmail( email ) ) table.put( PARENT, true );
	    if ( !checkEmailExistsInMap( table ) ) throw new AccountException( EXCEPTION_EMAIL_NOT_EXISTS + email );
	    
	    return table;
    }

    private boolean checkEmailExistsInMap( Map<String, Boolean> table ) {
        return table.containsKey( ACCOUNT ) || table.containsKey( PARENT );
    }

    private void checkAccountExists( int cardId, String action ) throws AccountException {
		boolean exists = accountDao.checkAccountExists( cardId );
		switch ( action ) {
		case CREATE:
			if ( exists ) throw new AccountException( EXCEPTION_ACCOUNT_ALREAD_EXISTS + cardId );
			break;
		case UPDATE:
			if ( !exists ) throw new AccountException( EXCEPTION_ACCOUNT_NOT_EXISTS + cardId );
			break;
		case DELETE:
			if ( !exists ) throw new AccountException( EXCEPTION_ACCOUNT_NOT_EXISTS + cardId );
			break;
		default:
			break;
		}
	}
	
}
