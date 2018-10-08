package com.polo.rest.polo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polo.rest.polo.dao.PaymentDao;
import com.polo.rest.polo.dto.ConvertionManager;
import com.polo.rest.polo.dto.PaymentDto;
import com.polo.rest.polo.entity.Payment;
import com.polo.rest.polo.exceptions.PaymentException;

import static com.polo.rest.polo.constants.ExceptionMessages.*;

@Service
public class PaymentService
{
    
    ConvertionManager convertionManagerInstance;
    
    public PaymentService() {
        convertionManagerInstance = ConvertionManager.getConvertionManager();
    }
    
    @Autowired
    private PaymentDao paymentDao;

    public PaymentDto getAccountByCardIdAndYear( int cardId, int year ) throws PaymentException {
    	checkPaymentExists(cardId, year);
        List<Payment> paymentEntityList = paymentDao.getAccountByCardId( cardId, year );
        return convertionManagerInstance.convertPaymentToDto( paymentEntityList, year );
    }

	private void checkPaymentExists(int cardId, int year) throws PaymentException {
		if ( !paymentDao.checkPaymentExists(cardId, year) ) {
			throw new PaymentException(EXCEPTION_PAYMENT_NOT_EXISTS + cardId + ", " + year);
		}
	}

}
