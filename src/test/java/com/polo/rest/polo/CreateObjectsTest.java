package com.polo.rest.polo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.polo.rest.polo.dto.AccountDto;
import com.polo.rest.polo.dto.ParentsDto;
import com.polo.rest.polo.entity.Account;
import com.polo.rest.polo.entity.Parent;

public class CreateObjectsTest {

	private static int randomIntSize = 10000000;
	
	 	public static AccountDto createAccountDto() {
	        AccountDto dtoAccount = new AccountDto();
	        dtoAccount.setName( UUID.randomUUID().toString() );
	        dtoAccount.setCardId( new Random().nextInt( randomIntSize ) );
	        dtoAccount.setMobileNumber( new Random().nextInt( randomIntSize ) );
	        dtoAccount.setPostalCode( UUID.randomUUID().toString() );
	        dtoAccount.setBirthday( new Date(1880,5,25) );
	        dtoAccount.setGender( "M" );
	        dtoAccount.setLevel( UUID.randomUUID().toString() );
	        dtoAccount.setSize( UUID.randomUUID().toString() );
	        dtoAccount.setObservations( UUID.randomUUID().toString() );
	        dtoAccount.setCc( true );
	        dtoAccount.setExam( true );
	        dtoAccount.setEnrolled( true );
	        dtoAccount.setEmail( UUID.randomUUID().toString() );
	        dtoAccount.setParents( createParentDtoList() );
	        
	        return dtoAccount;
	    }
	    
	 	public static List<ParentsDto> createParentDtoList() {
	 		List<ParentsDto> parentDtoList = new ArrayList<>();
	 		ParentsDto parentDto1 = createParentDto();
	 		ParentsDto parentDto2 = createParentDto();
	 		ParentsDto parentDto3 = createParentDto();
	        parentDtoList.add(parentDto1);
	        parentDtoList.add(parentDto2);
	        
	        return parentDtoList;
	    }

		private static ParentsDto createParentDto() {
			ParentsDto parentDto = new ParentsDto();
	        parentDto.setMobileNumber( new Random().nextInt( randomIntSize ) );
	        parentDto.setName( UUID.randomUUID().toString() );
	        parentDto.setEmail( UUID.randomUUID().toString() );
			return parentDto;
		}
	    
	 	public static Account createAccountEntity() {
	        Account entityAccount = new Account();
	        entityAccount.setId( new Random().nextInt( randomIntSize ) );
	        entityAccount.setName( UUID.randomUUID().toString() );
	        entityAccount.setCardId( new Random().nextInt( randomIntSize ) );
	        entityAccount.setMobileNumber( new Random().nextInt( randomIntSize ) );
	        entityAccount.setPostalCode( UUID.randomUUID().toString() );
	        entityAccount.setBirthday( new Date(1880,5,25) );
	        entityAccount.setGender( "M" );
	        entityAccount.setLevel( UUID.randomUUID().toString() );
	        entityAccount.setSize( UUID.randomUUID().toString() );
	        entityAccount.setObservations( UUID.randomUUID().toString() );
	        entityAccount.setCc( true );
	        entityAccount.setExam( true );
	        entityAccount.setEnrolled( true );
	        entityAccount.setEmail( UUID.randomUUID().toString() );
	        //entityAccount.setParentsList( createParentEntityList() );
	        
	        return entityAccount;
	    }
	    
	 	public static List<Parent> createParentEntityList() {
	 		List<Parent> parentsEntityList = new ArrayList<>();
	        Parent parentDto1 = createParentEntity();
	        Parent parentDto2 = createParentEntity();
	        parentsEntityList.add(parentDto1);
	        parentsEntityList.add(parentDto2);
	        
	        return parentsEntityList;
	    }

		private static Parent createParentEntity() {
			Parent parentDto = new Parent();
	        parentDto.setId( new Random().nextInt( randomIntSize ) );
	        parentDto.setMobileNumber( new Random().nextInt( randomIntSize ) );
	        parentDto.setName( UUID.randomUUID().toString() );
	        parentDto.setEmail( UUID.randomUUID().toString() );
	        
			return parentDto;
		}
	
}
