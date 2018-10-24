package com.polo.rest.polo.controller;

import static com.polo.rest.polo.constants.RestEndPoints.*;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polo.rest.polo.dto.ConvertionManager;
import com.polo.rest.polo.dto.PaymentDto;
import com.polo.rest.polo.entity.Payment;
import com.polo.rest.polo.exceptions.AccountException;
import com.polo.rest.polo.exceptions.PaymentException;
import com.polo.rest.polo.responses.ResponseJson;
import com.polo.rest.polo.service.PaymentService;

@RestController
public class PaymentControllerImpl
{
    
    @Autowired
    private PaymentService paymentService;

    @RequestMapping( value=PAYMENTS_GET_BY_CARD_ID_AND_YEAR )
    public PaymentDto getAccountPaymentsByCardIDAndYear( 
    		@PathVariable( value="cardId", required = true ) int cardId,
    		@PathVariable( value="year", required = true ) int year ) throws PaymentException {
        return paymentService.getPaymentByCardIdAndYear(cardId, year);
    }
    
    @RequestMapping( value=PAYMENTS_CREATE )
    public ResponseJson createAccountPayment( @RequestBody(required=true) PaymentDto paymentDto ) throws PaymentException, AccountException {
    	return paymentService.createAccountPayment( paymentDto );
    }
    
}
