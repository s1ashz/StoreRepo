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

    public List<Payment> getAccountByCardId( int cardId, int year ) {
        return paymentRepository.getByCardIdAndYear( cardId, year );
    }

	public boolean checkPaymentExists(int cardId, int year) {
		return paymentRepository.existsByCardIdAndYear(cardId, year);
	}

}
