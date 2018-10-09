package com.polo.rest.polo.dto;

import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.polo.rest.polo.constants.Months;
import com.polo.rest.polo.entity.Account;
import com.polo.rest.polo.entity.Parent;
import com.polo.rest.polo.entity.Payment;

public class ConvertionManager
{

    private static ConvertionManager convertionManagerInstance = null;
    private ConvertionManager() {}
    
    public static ConvertionManager getConvertionManager() {
        if ( null == convertionManagerInstance ) {
            convertionManagerInstance = new ConvertionManager();
        }
        return convertionManagerInstance;
    }
    
    public AccountDto convertAccountToDto( Account entityAccount) {
        AccountDto dtoAccount = new AccountDto();
        
        dtoAccount.setName( entityAccount.getName() );
        dtoAccount.setCardId( entityAccount.getCardId() );
        dtoAccount.setPostalCode( entityAccount.getPostalCode() );
        dtoAccount.setBirthday( entityAccount.getBirthday() );
        dtoAccount.setGender( entityAccount.getGender() );
        dtoAccount.setMobileNumber( entityAccount.getMobileNumber() );
        dtoAccount.setLevel( entityAccount.getLevel() );
        dtoAccount.setSize( entityAccount.getSize() );
        dtoAccount.setObservations( entityAccount.getObservations() );
        dtoAccount.setCc( entityAccount.isCc() );
        dtoAccount.setExam( entityAccount.isExam() );
        dtoAccount.setEnrolled( entityAccount.isEnrolled() );
        dtoAccount.setEmail( entityAccount.getEmail() );
        dtoAccount.setAddress( entityAccount.getAddress() );

        //dtoAccount.setParentsDtoList( convertParentsToDto( entityAccount.getParentsList() ) );
        
        return dtoAccount;
    }
    
    public List<ParentsDto> convertParentsToDto( List<Parent> entityParentsList ) {
    	List<ParentsDto> parentsDtoList = new ArrayList<>();
    	for ( Parent parent : entityParentsList  ) {
    		ParentsDto dtoParent = new ParentsDto();
    		dtoParent.setName( parent.getName() );
    		dtoParent.setEmail( parent.getEmail() );
    		dtoParent.setMobileNumber( parent.getMobileNumber() );
    		
    		parentsDtoList.add( dtoParent );
    	}
        return parentsDtoList;
    }
    
    public Account convertAccountToEntity( AccountDto dtoAccount) {
        Account entityAccount = new Account();
        
        entityAccount.setName( dtoAccount.getName() );
        entityAccount.setCardId( dtoAccount.getCardId() );
        entityAccount.setPostalCode( dtoAccount.getPostalCode() );
        entityAccount.setBirthday( dtoAccount.getBirthday() );
        entityAccount.setGender( dtoAccount.getGender() );
        entityAccount.setMobileNumber( dtoAccount.getMobileNumber() );
        entityAccount.setLevel( dtoAccount.getLevel() );
        entityAccount.setSize( dtoAccount.getSize() );
        entityAccount.setObservations( dtoAccount.getObservations() );
        entityAccount.setCc( dtoAccount.isCc() );
        entityAccount.setExam( dtoAccount.isExam() );
        entityAccount.setEnrolled( dtoAccount.isEnrolled() );
        entityAccount.setEmail( dtoAccount.getEmail() );
        entityAccount.setAddress( dtoAccount.getAddress() );

        //entityAccount.setParentsList( convertParentsDtoToEntity( dtoAccount.getParentsDtoList() ) );
        
        return entityAccount;
    }
    
    public List<Parent> convertParentsDtoToEntity( List<ParentsDto> dtoParentsList, Account accountEntity ) {
    	List<Parent> parentsEntityList = new ArrayList<>();
    	if ( null != dtoParentsList ) {
	    	for ( ParentsDto parentDto : dtoParentsList  ) {
	    		Parent entityParents = new Parent();
	            entityParents.setName( parentDto.getName() );
	            entityParents.setEmail( parentDto.getEmail() );
	            entityParents.setMobileNumber( parentDto.getMobileNumber() );
	    		entityParents.setAccount( accountEntity );
	            
	    		parentsEntityList.add( entityParents );
	    	}
    	}
        return parentsEntityList;
    }

    //PAYMENTS--------------

    public PaymentDto convertPaymentToDto( List<Payment> paymentEntityList, int year ) {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setYear( year );
        for (Payment payment : paymentEntityList ) {
            System.out.println( payment.getAmmount() );
            for (MonthPaymentsDto monthPayment : paymentDto.getMonthPayments() ) {
                if ( monthPayment.getMonth().equals( payment.getMonth().toUpperCase() )) {
                    monthPayment.setValue( payment.getAmmount() );
                }
            }
        }
        return paymentDto;
    }
    
    public List<Payment> convertPaymentDtoToEntity( PaymentDto paymentDto ) {
        
        List<Payment> paymentList = new ArrayList<>();
        
        
        for ( MonthPaymentsDto monthPayment : paymentDto.getMonthPayments() ) {
            Payment paymentEntity = new Payment();
            paymentEntity.setCardId( paymentDto.getCardId() );
            paymentEntity.setYear( paymentDto.getYear() );
            paymentEntity.setMonth( monthPayment.getMonth() );
            if ( 0.00 != monthPayment.getValue() ) {
                paymentEntity.setAmmount( monthPayment.getValue() );
                paymentEntity.setPaid( true );
            }
            paymentList.add( paymentEntity );
        }
        
        return paymentList;
    }
    
    
}
