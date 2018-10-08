package com.polo.rest.polo.controller;

import static com.polo.rest.polo.constants.RestEndPoints.PAYMENTS_GET_BY_CARD_ID;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polo.rest.polo.dto.PaymentDto;
import com.polo.rest.polo.exceptions.PaymentException;
import com.polo.rest.polo.service.PaymentService;

@RestController
public class PaymentControllerImpl
{
    
    @Autowired
    private PaymentService paymentService;

    @RequestMapping( value=PAYMENTS_GET_BY_CARD_ID )
    public PaymentDto getAccountPaymentsByCardIDAndYear( @PathVariable( value="cardId", required = true ) int cardId, @PathVariable( value="year", required = true ) int year ) throws PaymentException {
        return paymentService.getAccountByCardIdAndYear(cardId, year);
    }
    
    public void createAccountPayment() {
        
    }
    
    public List<PaymentDto> getAccountPayments() {
        // TODO Auto-generated method stub
        return null;
    }

    public ResponseEntity updatePayment() {
        // TODO Auto-generated method stub
        return null;
    }
    
    

}
