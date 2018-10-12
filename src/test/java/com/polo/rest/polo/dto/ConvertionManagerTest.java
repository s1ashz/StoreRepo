package com.polo.rest.polo.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.polo.rest.polo.CreateObjectsTest;
import com.polo.rest.polo.entity.Account;
import com.polo.rest.polo.entity.Parent;
import com.polo.rest.polo.entity.Payment;

@RunWith(SpringRunner.class)
public class ConvertionManagerTest
{
    
    private ConvertionManager convertionManager = null;
    private AccountDto dtoAccount;
    private Account entityAccount;
    private List<Parent> parentEntityList;
    private List<ParentsDto> parentDtoList;
    
    private PaymentDto paymentDto;
    private List<Payment> paymentList;
    
    @Before
    public void before() {
        convertionManager = ConvertionManager.getConvertionManager();
        dtoAccount = CreateObjectsTest.createAccountDto();
        entityAccount = CreateObjectsTest.createAccountEntity();
        parentEntityList = CreateObjectsTest.createParentEntityList();
        parentDtoList = CreateObjectsTest.createParentDtoList();
        paymentDto = CreateObjectsTest.createPaymentDto();
        paymentList = CreateObjectsTest.createPaymentEntityList();
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
    public void testParentEntityToDtoConversion() {
        
        List<ParentsDto> convertedParentDtoList = ConvertionManager.getConvertionManager().convertParentsToDto( parentEntityList );
        
        for ( int i = 0; i < convertedParentDtoList.size(); i++ ) {
        	assertEquals( convertedParentDtoList.get(i).getName(), parentEntityList.get(i).getName() );
        	assertEquals( convertedParentDtoList.get(i).getEmail(), parentEntityList.get(i).getEmail() );
        	assertEquals( convertedParentDtoList.get(i).getMobileNumber(), parentEntityList.get(i).getMobileNumber() );
        }
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
    
    @Test
    public void testParentDtoToEntityConversion() {
        
        List<Parent> convertedParentEntityList = ConvertionManager.getConvertionManager().convertParentsDtoToEntity( parentDtoList, entityAccount );
        
        for ( int i = 0; i < convertedParentEntityList.size(); i++ ) {
            assertEquals( convertedParentEntityList.get(i).getName(), parentDtoList.get(i).getName() );
            assertEquals( convertedParentEntityList.get(i).getEmail(), parentDtoList.get(i).getEmail() );
            assertEquals( convertedParentEntityList.get(i).getMobileNumber(), parentDtoList.get(i).getMobileNumber() );
            assertEquals( convertedParentEntityList.get(i).getAccount(), entityAccount );
        }
    }
    
    //PAYMENTS-------------------
    
    @Test
    public void testPaymentToDtoConversion() {
        int cardId = 10;
        int year = 2018;
        PaymentDto convertedPaymentDto = ConvertionManager.getConvertionManager().convertPaymentToDto( paymentList, cardId, year );
        assertEquals( convertedPaymentDto.getCardId(), cardId );
        assertEquals( convertedPaymentDto.getYear(), year );
        int count = 0;
        for ( MonthPaymentsDto month : convertedPaymentDto.getMonthPayments() ) {
            for ( Payment payment : paymentList) {
                if ( month.getMonth() == payment.getMonth() ) {
                    count++;
                    assertEquals( month.getMonth(), payment.getMonth() );
                    assertEquals( month.getValue(), payment.getAmmount(), 001 );
                }
                
            }
        }
        assertEquals( count, paymentList.size() );
    }
    
    @Test
    public void testPaymentDtoToEntityConversion() {
        List<Payment> convertedPaymentEntityList = ConvertionManager.getConvertionManager().convertPaymentDtoToEntity( paymentDto );
        for ( Payment convertedPaymentEntity : convertedPaymentEntityList ) {
            assertEquals( convertedPaymentEntity.getCardId(), paymentDto.getCardId() );
            assertEquals( convertedPaymentEntity.getYear(), paymentDto.getYear() );
            boolean exists = false;
            for ( MonthPaymentsDto monthPaid : paymentDto.getMonthPayments() ) {
                if ( convertedPaymentEntity.getMonth() == monthPaid.getMonth() ) {
                    exists = true;
                    assertEquals( convertedPaymentEntity.getMonth(), monthPaid.getMonth() );
                    System.out.println( convertedPaymentEntity.getAmmount() );
                    System.out.println( monthPaid.getValue() );
                    assertEquals( convertedPaymentEntity.getAmmount(), monthPaid.getValue(), 0.0001 );
                    continue;
                }
            }
            if (!exists) {
                fail();
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
