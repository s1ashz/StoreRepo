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

import com.polo.rest.polo.entity.Account;
import com.polo.rest.polo.entity.Parents;

@RunWith(SpringRunner.class)
public class ConvertionManagerTest
{
    
    private ConvertionManager convertionManager = null;
    private AccountDto dtoAccount;
    private Account entityAccount;
    
    @Before
    public void before() {
        convertionManager = ConvertionManager.getConvertionManager();
        dtoAccount = createAccountDto();
        entityAccount = createAccountEntity();
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
        
        assertEquals( entityTest.getParents().getName(), dtoAccount.getParentsDto().getName() );
        assertEquals( entityTest.getParents().getEmail(), dtoAccount.getParentsDto().getEmail() );
        assertEquals( entityTest.getParents().getMobileNumber(), dtoAccount.getParentsDto().getMobileNumber() );
        assertNotEquals( entityTest.getParents().getId(), dtoAccount.getParentsDto().getId() );
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
    
    private AccountDto createAccountDto() {
        
        AccountDto dtoAccount = new AccountDto();
        dtoAccount.setName( UUID.randomUUID().toString() );
        dtoAccount.setCardId( new Random().nextInt( 10000 ) );
        dtoAccount.setMobileNumber( new Random().nextInt( 10000 ) );
        dtoAccount.setPostalCode( UUID.randomUUID().toString() );
        dtoAccount.setBirthday( UUID.randomUUID().toString() );
        dtoAccount.setGender( UUID.randomUUID().toString() );
        dtoAccount.setLevel( UUID.randomUUID().toString() );
        dtoAccount.setSize( UUID.randomUUID().toString() );
        dtoAccount.setObservations( UUID.randomUUID().toString() );
        dtoAccount.setCc( true );
        dtoAccount.setExam( true );
        dtoAccount.setEnrolled( true );
        dtoAccount.setParentsDto( createParentDto() );
        
        return dtoAccount;
    }
    
    private ParentsDto createParentDto() {

        ParentsDto parentDto = new ParentsDto();
        parentDto.setId( new Random().nextInt( 10000 ) );
        parentDto.setMobileNumber( new Random().nextInt( 10000 ) );
        parentDto.setName( UUID.randomUUID().toString() );
        parentDto.setEmail( UUID.randomUUID().toString() );
        
        return parentDto;
    }
    
    private Account createAccountEntity() {
        
        Account entityAccount = new Account();
        entityAccount.setId( new Random().nextInt( 10000 ) );
        entityAccount.setName( UUID.randomUUID().toString() );
        entityAccount.setCardId( new Random().nextInt( 10000 ) );
        entityAccount.setMobileNumber( new Random().nextInt( 10000 ) );
        entityAccount.setPostalCode( UUID.randomUUID().toString() );
        entityAccount.setBirthday( UUID.randomUUID().toString() );
        entityAccount.setGender( UUID.randomUUID().toString() );
        entityAccount.setLevel( UUID.randomUUID().toString() );
        entityAccount.setSize( UUID.randomUUID().toString() );
        entityAccount.setObservations( UUID.randomUUID().toString() );
        entityAccount.setCc( true );
        entityAccount.setExam( true );
        entityAccount.setEnrolled( true );
        entityAccount.setParents( createParentEntity() );
        
        return entityAccount;
    }
    
    private Parents createParentEntity() {

        Parents parentDto = new Parents();
        parentDto.setId( new Random().nextInt( 10000 ) );
        parentDto.setMobileNumber( new Random().nextInt( 10000 ) );
        parentDto.setName( UUID.randomUUID().toString() );
        parentDto.setEmail( UUID.randomUUID().toString() );
        
        return parentDto;
    }
    
}
