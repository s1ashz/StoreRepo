package com.polo.rest.polo.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Random;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.polo.rest.polo.CreateObjectsTest;
import com.polo.rest.polo.entity.Account;
import com.polo.rest.polo.entity.Parent;

@RunWith(SpringRunner.class)
public class ConvertionManagerTest
{
    
    private ConvertionManager convertionManager = null;
    private AccountDto dtoAccount;
    private Account entityAccount;
    
    @Before
    public void before() {
        convertionManager = ConvertionManager.getConvertionManager();
        dtoAccount = CreateObjectsTest.createAccountDto();
        entityAccount = CreateObjectsTest.createAccountEntity();
    }
    
    @Test
    public void testSingleton() {
        ConvertionManager newConvertionManager = ConvertionManager.getConvertionManager();
        assertNotNull( newConvertionManager );
        assertEquals( convertionManager, newConvertionManager );
    }

    @Test
    public void testEntityConversion() {
        Account entityTest = convertionManager.convertAccountToEntity( dtoAccount );
        
        assertEquals( entityTest.getName(), dtoAccount.getName() );
        assertEquals( entityTest.getCardId(), dtoAccount.getCardId() );
        assertEquals( entityTest.getMobileNumber(), dtoAccount.getMobileNumber() );
        assertEquals( entityTest.getPostalCode(), dtoAccount.getPostalCode() );
        assertEquals( entityTest.getBirthday(), dtoAccount.getBirthday() );
        assertEquals( entityTest.getGender(), dtoAccount.getGender() );
        assertEquals( entityTest.getLevel(), dtoAccount.getLevel() );
        assertEquals( entityTest.getSize(), dtoAccount.getSize() );
        assertEquals( entityTest.getObservations(), dtoAccount.getObservations() );
        assertEquals( entityTest.isCc(), dtoAccount.isCc() );
        assertEquals( entityTest.isExam(), dtoAccount.isExam() );
        assertEquals( entityTest.isEnrolled(), dtoAccount.isEnrolled() );

    }
    
    @Test
    public void testEntityParentConversion() {
        Account entityTest = convertionManager.convertAccountToEntity( dtoAccount );
        
//        for ( int i = 0; i < entityTest.getParentsList().size(); i++ ) {
//        	assertEquals( entityTest.getParentsList().get(i).getName(), dtoAccount.getParentsDtoList().get(i).getName() );
//        	assertEquals( entityTest.getParentsList().get(i).getEmail(), dtoAccount.getParentsDtoList().get(i).getEmail() );
//        	assertEquals( entityTest.getParentsList().get(i).getMobileNumber(), dtoAccount.getParentsDtoList().get(i).getMobileNumber() );
//        }
        
    }
    
    @Test
    public void testDtoConversion() {
        AccountDto dtoTest = convertionManager.convertAccountToDto( entityAccount );
        
        assertEquals( dtoTest.getName(), entityAccount.getName() );
        assertEquals( dtoTest.getCardId(), entityAccount.getCardId() );
        assertEquals( dtoTest.getMobileNumber(), entityAccount.getMobileNumber() );
        assertEquals( dtoTest.getPostalCode(), entityAccount.getPostalCode() );
        assertEquals( dtoTest.getBirthday(), entityAccount.getBirthday() );
        assertEquals( dtoTest.getGender(), entityAccount.getGender() );
        assertEquals( dtoTest.getLevel(), entityAccount.getLevel() );
        assertEquals( dtoTest.getSize(), entityAccount.getSize() );
        assertEquals( dtoTest.getObservations(), entityAccount.getObservations() );
        assertEquals( dtoTest.isCc(), entityAccount.isCc() );
        assertEquals( dtoTest.isExam(), entityAccount.isExam() );
        assertEquals( dtoTest.isEnrolled(), entityAccount.isEnrolled() );
        
    }
    
}
