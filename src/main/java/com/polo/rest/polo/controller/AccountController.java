package com.polo.rest.polo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.polo.rest.polo.dto.AccountDto;
import com.polo.rest.polo.dto.PaymentDto;

public interface AccountController
{

    ResponseEntity validateAccount();
    AccountDto getAccount();
    ResponseEntity createAccount();
    List<AccountDto> getAccounts();
    List<PaymentDto> getAccountPayments();
    List<PaymentDto> getAccountPaymentsByYear();
    ResponseEntity updatePayment();
    
}
