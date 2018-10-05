package com.polo.rest.polo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polo.rest.polo.dto.AccountDto;
import com.polo.rest.polo.dto.PaymentDto;
import com.polo.rest.polo.validators.AccountValidator;

@RestController
public class AccountControllerImpl
{

    @Autowired
    private AccountValidator accountValidator;
    
    public AccountControllerImpl() {
    }
    
    @RequestMapping("/")
    public String index() {
        
        return ResponseEntity.ok().build().toString();
    }

    public ResponseEntity validateAccount() {
        return null;
        
    }

    public AccountDto getAccount() {
    	
        return null;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    public ResponseEntity createAccount() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<AccountDto> getAccounts() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<PaymentDto> getAccountPayments() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<PaymentDto> getAccountPaymentsByYear() {
        // TODO Auto-generated method stub
        return null;
    }

    public ResponseEntity updatePayment() {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    
    
    
    
}
