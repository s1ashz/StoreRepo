package com.polo.rest.polo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.polo.rest.polo.entity.Payment;
import com.polo.rest.polo.repository.PaymentRepository;

@Repository
public class PaymentDao
{
    
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getPaymentByCardId( int cardId, int year ) {
        return paymentRepository.getByCardIdAndYear( cardId, year );
    }

	public boolean checkPaymentExistsByCardIdAndYear(int cardId, int year) {
		return paymentRepository.existsByCardIdAndYear(cardId, year);
	}
	
	public boolean checkPaymentExistsByCardIdAndYearAndMonth(int cardId, int year, int monthIndex) {
		return paymentRepository.existsByCardIdAndYearAndMonth(cardId, year, monthIndex);
	}

    public List<Integer> getPaymentYearsList( int cardId ) {
        return paymentRepository.findDistinctYearByCardId(cardId);
    }

	public void createPayment(Payment payment) {
		paymentRepository.save(payment);
	}

	public Payment getPaymentByCardIdAndYearAndMonth( int cardId, int year, int monthIndex ) {
		return paymentRepository.getByCardIdAndYearAndMonth(cardId, year, monthIndex);
		
	}

}
