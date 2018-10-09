package com.polo.rest.polo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polo.rest.polo.dao.PaymentDao;
import com.polo.rest.polo.dto.ConvertionManager;
import com.polo.rest.polo.dto.PaymentDto;
import com.polo.rest.polo.entity.Payment;
import com.polo.rest.polo.exceptions.PaymentException;
import com.polo.rest.polo.responses.ResponseJson;

import static com.polo.rest.polo.constants.ExceptionMessages.*;

@Service
public class PaymentService
{
    
    @Autowired
    private PaymentDao paymentDao;
    
    ConvertionManager convertionManagerInstance;
    
    public PaymentService() {
        convertionManagerInstance = ConvertionManager.getConvertionManager();
    }

    public PaymentDto getAccountByCardIdAndYear( int cardId, int year ) throws PaymentException {
    	checkPaymentExistsWithCardIdAndYear(cardId, year);
        List<Payment> paymentEntityList = paymentDao.getAccountByCardId( cardId, year );
        return convertionManagerInstance.convertPaymentToDto( paymentEntityList, cardId, year );
    }

	public ResponseJson createAccountPayment( PaymentDto paymentDto ) throws PaymentException {
		
		List<Payment> paymentEntityList = convertionManagerInstance.convertPaymentDtoToEntity( paymentDto );
		
		for (Payment payment : paymentEntityList ) {
			System.out.println("INSIDE " + payment.isPaid());
			
			//if ( !payment.isPaid() ) continue;
			
			if ( checkPaymentExistsWithCardIdAndYearAndMonth(payment.getCardId(), payment.getYear(), payment.getMonth().toUpperCase()) ) {
				Payment existingPayment = paymentDao.getPaymentByCardIdAndYearAndMonth(payment.getCardId(), payment.getYear(), payment.getMonth().toUpperCase());
				payment.setId( existingPayment.getId() );;
				existingPayment.setAmmount( payment.getAmmount() );
				existingPayment.setPaid( payment.isPaid() );
				System.out.println(existingPayment.toString());
				paymentDao.createPayment( existingPayment );
				
			} else {
				paymentDao.createPayment( payment );
			}
		}
		return null;
	}
	
	private void checkPaymentExistsWithCardIdAndYear(int cardId, int year) throws PaymentException {
		if ( !paymentDao.checkPaymentExistsByCardIdAndYear(cardId, year) ) {
			throw new PaymentException(EXCEPTION_PAYMENT_NOT_EXISTS + cardId + ", " + year);
		}
	}
	
	private boolean checkPaymentExistsWithCardIdAndYearAndMonth( int cardId, int year, String month ) throws PaymentException {
		return paymentDao.checkPaymentExistsByCardIdAndYearAndMonth(cardId, year, month );
	}
	
	

}
