package com.polo.rest.polo.validators;

import static com.polo.rest.polo.constants.ExceptionMessages.EXCEPTION_INVALID_ACCOUNT_MESSAGE;
import static com.polo.rest.polo.constants.ExceptionMessages.EXCEPTION_INVALID_PARENT_MESSAGE;
import static com.polo.rest.polo.constants.ExceptionMessages.EXCEPTION_PARENT_NULL;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.stereotype.Component;

import com.polo.rest.polo.dto.AccountDto;
import com.polo.rest.polo.dto.ParentsDto;
import com.polo.rest.polo.exceptions.AccountException;

@Component
public class AccountValidator
{
	
    public AccountValidator() {
    }
    
    public void validateAccount( AccountDto accountDto) throws AccountException {
    	for ( Field accountField: accountDto.getClass().getDeclaredFields() ) {
    			accountField.setAccessible(true);
    			try {
					validateAccountField(accountDto, accountField);
					validateParents(accountField, accountDto);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
    	}
    }

	private void validateParents(Field accountField, AccountDto accountDto) throws IllegalAccessException, SecurityException, AccountException {
		if (checkFieldIsParentsDtoAndYearsPaid(accountField) && !checkFieldNull(accountDto, accountField) ) {
			if ( null == accountDto.getParents() ) throw new AccountException( EXCEPTION_PARENT_NULL);
			for ( ParentsDto parentDto : accountDto.getParents() ) {
				if ( null == parentDto ) {
					throw new AccountException( EXCEPTION_PARENT_NULL );
				} else {
					for ( Field parentsField : parentDto.getClass().getDeclaredFields() ) {
						parentsField.setAccessible(true);
						checkParentsFieldNotNull(parentDto, parentsField);
					}
				}
			}
		}
	}

	private void checkParentsFieldNotNull(ParentsDto parentDto, Field parentsField)
			throws IllegalAccessException, AccountException {
		if ( null == parentsField.get( parentDto ) ) {
			throw new AccountException( EXCEPTION_INVALID_PARENT_MESSAGE + parentsField.getName() );
		}
	}

	private void validateAccountField(AccountDto accountDto, Field accountField) throws IllegalAccessException, AccountException {
		if ( !checkFieldIsParentsDtoAndYearsPaid(accountField) && checkFieldNull(accountDto, accountField) ) {
			throw new AccountException( EXCEPTION_INVALID_ACCOUNT_MESSAGE + accountField.getName() );
		}
	}

	private boolean checkFieldNull(AccountDto accountDto, Field accountField) throws IllegalAccessException {
		return null == accountField.get(accountDto);
	}

	private boolean checkFieldIsParentsDtoAndYearsPaid(Field accountField) {
		return accountField.getType().getSimpleName().equals(List.class.getSimpleName() );
	}
    
}
