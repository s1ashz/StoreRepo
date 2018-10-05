package com.polo.rest.polo.validators;

import java.lang.reflect.Field;

import javax.security.auth.login.AccountException;

import org.springframework.stereotype.Component;

import com.polo.rest.polo.dto.AccountDto;


@Component
public class AccountValidator
{
	private static String INT = "int";
	private static String INTEGER = "Ingeter";

    public AccountValidator() {
    }
    
    public static void validateAccount( AccountDto accountDto) throws AccountException {
    	
    	for ( Field f: accountDto.getClass().getDeclaredFields() ) {
    		try {
    			f.setAccessible(true);
    			
    			System.out.println("------");
    			System.out.println("NAME:   " + f.getName());
    			System.out.println("TYPE:   " + f.getType());
    			System.out.println("VALUE:  " + f.get(accountDto));
    			
    			String fieldType = f.getType().getName();
    			
    			if ( f.getName() == "name" && f.get(accountDto) == null) {
    				throw new AccountException( "Account Name cannot be null" );
    			}
    			
    			if ( f.getName() == "cardId" && f.get(accountDto) == "0") {
    				throw new AccountException( "Account CardId cannot be 0" );
    			}
    			
    			
//    			if ( ( fieldType ==  INT ) || ( fieldType == INTEGER ) ) {
//    				System.out.println("leeel int");
//    			}
    			
    			
//				if ( f.get(accountDto) != null ) {
//					System.out.println("not null");
//				}
				
				
				
				System.out.println("------");
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    }
    
    public static void main(String[] args) {
    	
    	AccountDto accountDto = new AccountDto();
    	//accountDto.setName("puta");
    	accountDto.setBirthday("cona");
    	
    	try {
			validateAccount( accountDto );
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println( e.getMessage() );
		}
    	
    }
    
    
}
