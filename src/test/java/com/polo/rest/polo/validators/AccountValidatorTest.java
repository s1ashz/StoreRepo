package com.polo.rest.polo.validators;

import static com.polo.rest.polo.constants.ExceptionMessages.EXCEPTION_INVALID_ACCOUNT_MESSAGE;
import static com.polo.rest.polo.constants.ExceptionMessages.EXCEPTION_INVALID_PARENT_MESSAGE;
import static com.polo.rest.polo.constants.ExceptionMessages.EXCEPTION_PARENT_NULL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.polo.rest.polo.CreateObjectsTest;
import com.polo.rest.polo.dto.AccountDto;
import com.polo.rest.polo.dto.ParentsDto;
import com.polo.rest.polo.exceptions.AccountException;

@RunWith(SpringRunner.class)
public class AccountValidatorTest {
	
	@InjectMocks
	private AccountValidator accountValidator;
	private AccountDto accountDto;
	
	private String INVALID_ACCOUNT_MESSAGE_TEST = EXCEPTION_INVALID_ACCOUNT_MESSAGE;
	private String EXCEPTION_INVALID_PARENT_MESSAGE_TEST = EXCEPTION_INVALID_PARENT_MESSAGE;
	private String EXCEPTION_PARENT_NULL_TEST = EXCEPTION_PARENT_NULL;
	
	Map<String, String> accountFieldNamesMap;
	Map<String, String> parentsFieldNamesMap;
	
	@Before
	public void instantiate() {
		MockitoAnnotations.initMocks(this);
		accountDto = CreateObjectsTest.createAccountDto();
		accountFieldNamesMap = new HashMap<>();
		parentsFieldNamesMap = new HashMap<>();
		fillMapWithAccountFieldsName();
		fillMapWithParentsFieldsName();
	}

	@Test()
	public void validateDtoFieldTest1() throws AccountException {
		String nullFieldName;
		
		//Name Test
		nullFieldName = accountFieldNamesMap.get( accountDto.getName() );
		accountDto.setName(null);
		assertNotNull( asserAccountException( accountDto, INVALID_ACCOUNT_MESSAGE_TEST, nullFieldName ) );
	}
	
	@Test()
	public void validateDtoFieldTest2() throws AccountException {
		String nullFieldName;
		
		//Birthday Test
		nullFieldName = accountFieldNamesMap.get( "" + accountDto.getBirthday().getYear() + accountDto.getBirthday().getMonth() + accountDto.getBirthday().getDay() );
		accountDto.setBirthday(null);
		assertNotNull( asserAccountException( accountDto, INVALID_ACCOUNT_MESSAGE_TEST, nullFieldName ) );
	}
	
	@Test()
	public void validateDtoFieldTest3() throws AccountException {
		String nullFieldName;
		
		//Gender Test
		nullFieldName = accountFieldNamesMap.get( accountDto.getGender() );
		accountDto.setGender(null);
		assertNotNull( asserAccountException( accountDto, INVALID_ACCOUNT_MESSAGE_TEST, nullFieldName ) );
	}
	
	@Test()
	public void validateDtoFieldTest4() throws AccountException {
		String nullFieldName;	
		
		//Level Test
		nullFieldName = accountFieldNamesMap.get( accountDto.getLevel() );
		accountDto.setLevel(null);
		assertNotNull( asserAccountException( accountDto, INVALID_ACCOUNT_MESSAGE_TEST, nullFieldName ) );
	}
	
	@Test()
	public void validateDtoFieldTest5() throws AccountException {
		String nullFieldName;	
		
		//PostalCode Test
		nullFieldName = accountFieldNamesMap.get( accountDto.getPostalCode() );
		accountDto.setPostalCode(null);
		assertNotNull( asserAccountException( accountDto, INVALID_ACCOUNT_MESSAGE_TEST, nullFieldName ) );
	}
	
	@Test()
	public void validateDtoFieldTest6() throws AccountException {
		String nullFieldName;		
		//Size Test
		nullFieldName = accountFieldNamesMap.get( accountDto.getSize() );
		accountDto.setSize(null);
		assertNotNull( asserAccountException( accountDto, INVALID_ACCOUNT_MESSAGE_TEST, nullFieldName ) );
	}
	
	@Test()
	public void validateDtoFieldTest7() throws AccountException {
		String nullFieldName;		
		//Parents Test
		nullFieldName = accountFieldNamesMap.get( accountDto.getParents().toString() );
		accountDto.setParents(null);
		assertNotNull( asserAccountException( accountDto, EXCEPTION_PARENT_NULL_TEST, nullFieldName ) );
	}
	
	@Test()
	public void validateDtoFieldTest8() throws AccountException {
		String nullFieldName;	
		//Parent Name Test
		for ( ParentsDto parent : accountDto.getParents() ) {
			nullFieldName = parentsFieldNamesMap.get( parent.getName() );
			parent.setName( null );
			asserAccountException( accountDto, EXCEPTION_INVALID_PARENT_MESSAGE_TEST, nullFieldName );
		}
	}
	
	@Test()
	public void validateDtoFieldTest9() throws AccountException {
		String nullFieldName;	
		//Parent Email Test
		for ( ParentsDto parent : accountDto.getParents() ) {
			nullFieldName = parentsFieldNamesMap.get( parent.getEmail() );
			parent.setEmail( null );
			asserAccountException( accountDto, EXCEPTION_INVALID_PARENT_MESSAGE_TEST, nullFieldName );
		}
	}
	
	@Test()
	public void validateDtoFieldTest10() throws AccountException {
		String nullFieldName;		
		//Parents Test
		nullFieldName = accountFieldNamesMap.get( accountDto.getParents().get(0).toString() );
		accountDto.getParents().set(0, null);
		assertNotNull( asserAccountException( accountDto, EXCEPTION_PARENT_NULL_TEST, nullFieldName ) );
	}
	
	private Exception asserAccountException(AccountDto accountDto, String expectedExceptionMessage, String failedFieldName) throws AccountException {
		try {
			accountValidator.validateAccount(accountDto);
		} catch (AccountException ex) {
			if ( null == failedFieldName ) {
				assertEquals( expectedExceptionMessage, ex.getMessage() );
			} else {
				assertEquals( ex.getMessage(), expectedExceptionMessage + failedFieldName);
			}
			return ex;
		}
		return null;
	}
	
	private void fillMapWithAccountFieldsName() {
		for ( Field accountField : accountDto.getClass().getDeclaredFields() ) {
			try {
				accountField.setAccessible(true);
				if ( accountField.get(accountDto) instanceof Date ) {
				    Date datelabel = (Date) accountField.get(accountDto);
				    accountFieldNamesMap.put( "" + datelabel.getYear() + datelabel.getMonth() + datelabel.getDay() , accountField.getName().toString() );
				} else if( accountField.get( accountDto ) instanceof List<?> ) {
					//Years and Parents list
				} else {
				    accountFieldNamesMap.put(accountField.get(accountDto).toString(), accountField.getName().toString() );
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void fillMapWithParentsFieldsName() {
		for ( ParentsDto parentDto : accountDto.getParents() ) {
			for ( Field parentField : parentDto.getClass().getDeclaredFields() ) {
				try {
					parentField.setAccessible(true);
					parentsFieldNamesMap.put(parentField.get(parentDto).toString(), parentField.getName().toString() );
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void printMap( Map<String, String> map ) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
		    System.out.println(entry.getKey()+" : "+entry.getValue());
		}
	}
}
