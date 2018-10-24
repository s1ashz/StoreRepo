package com.polo.rest.polo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polo.rest.polo.dao.AccountDao;
import com.polo.rest.polo.dao.PaymentDao;
import com.polo.rest.polo.dto.ConvertionManager;
import com.polo.rest.polo.dto.PaymentDto;
import com.polo.rest.polo.entity.Payment;
import com.polo.rest.polo.exceptions.AccountException;
import com.polo.rest.polo.exceptions.PaymentException;
import com.polo.rest.polo.responses.ResponseJson;

import static com.polo.rest.polo.constants.ExceptionMessages.*;
import static com.polo.rest.polo.constants.Actions.*;

@Service
public class PaymentService
{
    
    @Autowired
    private PaymentDao paymentDao;
    
    @Autowired
    private AccountDao accountDao;
    
    ConvertionManager convertionManagerInstance;
    
    public PaymentService() {
        convertionManagerInstance = ConvertionManager.getConvertionManager();
    }

    public PaymentDto getPaymentByCardIdAndYear( int cardId, int year ) throws PaymentException {
    	checkPaymentExistsWithCardIdAndYear(cardId, year);
        List<Payment> paymentEntityList = paymentDao.getPaymentByCardId( cardId, year );
        return convertionManagerInstance.convertPaymentToDto( paymentEntityList, cardId, year );
    }

	public ResponseJson createAccountPayment( PaymentDto paymentDto ) throws PaymentException, AccountException {
		checkAccountExists( paymentDto.getCardId(), UPDATE );
		if ( null == paymentDto.getMonthPayments() || paymentDto.getMonthPayments().isEmpty() ) {
			createSeassonPayment(paymentDto); //Creates an empty row with just the cardId and Year
			return new ResponseJson( CREATE, true );
		}
		List<Payment> paymentEntityList = convertionManagerInstance.convertPaymentDtoToEntity( paymentDto );
		for (Payment payment : paymentEntityList ) {
			createAndUpdatePayment(payment);
		}
		return new ResponseJson( CREATE, true );
	}

	private void createSeassonPayment(PaymentDto paymentDto) {
		Payment payment = new Payment();
		payment.setCardId( paymentDto.getCardId() );
		payment.setYear( paymentDto.getYear() );
		
		paymentDao.createPayment(payment);
	}

	private void createAndUpdatePayment(Payment payment) throws PaymentException {
		if ( checkPaymentExistsWithCardIdAndYearAndMonth(payment.getCardId(), payment.getYear(), payment.getMonth() ) ) {
			updatePayment( payment );
		} else {
			paymentDao.createPayment( payment );
		}
	}

    private void updatePayment( Payment payment ) {
        Payment existingPayment = paymentDao.getPaymentByCardIdAndYearAndMonth(payment.getCardId(), payment.getYear(), payment.getMonth() );
        payment.setId( existingPayment.getId() );;
        existingPayment.setAmmount( payment.getAmmount() );
        existingPayment.setPaid( payment.isPaid() );
        paymentDao.createPayment( existingPayment );
    }
	
	private void checkPaymentExistsWithCardIdAndYear(int cardId, int year) throws PaymentException {
		if ( !paymentDao.checkPaymentExistsByCardIdAndYear(cardId, year) ) {
			throw new PaymentException(EXCEPTION_PAYMENT_NOT_EXISTS + cardId + ", " + year);
		}
	}
	
	private boolean checkPaymentExistsWithCardIdAndYearAndMonth( int cardId, int year, int monthIndex ) throws PaymentException {
		return paymentDao.checkPaymentExistsByCardIdAndYearAndMonth(cardId, year, monthIndex );
	}

	private void checkAccountExists( int cardId, String action ) throws AccountException {
		boolean exists = accountDao.checkAccountExists( cardId );
		switch ( action ) {
		case CREATE:
			if ( exists ) throw new AccountException( EXCEPTION_ACCOUNT_ALREAD_EXISTS + cardId );
			break;
		case UPDATE:
			if ( !exists ) throw new AccountException( EXCEPTION_ACCOUNT_NOT_EXISTS + cardId );
			break;
		case DELETE:
			if ( !exists ) throw new AccountException( EXCEPTION_ACCOUNT_NOT_EXISTS + cardId );
			break;
		default:
			break;
		}
	}
	
}
