package com.polo.rest.polo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.polo.rest.polo.constants.Months;
import com.polo.rest.polo.convertor.ConvertionManager;
import com.polo.rest.polo.dto.AccountDto;
import com.polo.rest.polo.dto.ParentsDto;
import com.polo.rest.polo.dto.PaymentDto;
import com.polo.rest.polo.entity.Account;
import com.polo.rest.polo.entity.Parent;
import com.polo.rest.polo.entity.Payment;

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
	        dtoAccount.setAddress( UUID.randomUUID().toString() );
	        List<Integer> yearsPaid = new ArrayList<>();
	        dtoAccount.setYearsPaid(yearsPaid);

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
	        entityAccount.setAddress( UUID.randomUUID().toString() );
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
		
		//PAYMENTS --------------
		
		public static PaymentDto createPaymentDto() {
	        PaymentDto paymentDto = new PaymentDto();
	        paymentDto.setYear( new Random().nextInt( randomIntSize ) );
	        paymentDto.setCardId( new Random().nextInt( randomIntSize ) );
	        paymentDto.getMonthPayments().get( 0 ).setValue( new Random().nextInt( randomIntSize ) );
	        paymentDto.getMonthPayments().get( new Random().nextInt( 11 ) ).setValue( new Random().nextInt( randomIntSize ) );
	        paymentDto.getMonthPayments().get( new Random().nextInt( 11 ) ).setValue( new Random().nextInt( randomIntSize ) );
	        paymentDto.getMonthPayments().get( new Random().nextInt( 11 ) ).setValue( new Random().nextInt( randomIntSize ) );
	        paymentDto.getMonthPayments().get( new Random().nextInt( 11 ) ).setValue( new Random().nextInt( randomIntSize ) );
	        paymentDto.getMonthPayments().get( new Random().nextInt( 11 ) ).setValue( new Random().nextInt( randomIntSize ) );
	        
	        return paymentDto;
	    }

        public static List<Payment> createPaymentEntityList() {
            List<Payment> paymentList = new ArrayList<>();
            Payment payment1 = createPayment( Months.JANUARY.getMonthIndex() );
            Payment payment2 = createPayment( Months.APRIL.getMonthIndex() );
            Payment payment3 = createPayment( Months.JULY.getMonthIndex() );
            Payment payment4 = createPayment( Months.SEPTEMBER.getMonthIndex() );
            Payment payment5 = createPayment( Months.DECEMBER.getMonthIndex() );
            
            paymentList.add( payment1 );
            paymentList.add( payment2 );
            paymentList.add( payment3 );
            paymentList.add( payment4 );
            paymentList.add( payment5 );
            
            return paymentList;
        }

        private static Payment createPayment( int month ) {
            Payment payment = new Payment();
            payment.setAmmount( new Random().nextInt( randomIntSize ) );
            payment.setYear( new Random().nextInt( randomIntSize ) );
            payment.setCardId( new Random().nextInt( randomIntSize ) );
            payment.setPaid( true );
            payment.setMonth( month );
            return payment;
        }
		
		
        
        
        
        
        
        
        
        
}
