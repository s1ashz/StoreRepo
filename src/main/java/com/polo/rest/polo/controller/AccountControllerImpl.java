package com.polo.rest.polo.controller;

import static com.polo.rest.polo.constants.RestEndPoints.ACCOUNT_CREATE;
import static com.polo.rest.polo.constants.RestEndPoints.ACCOUNT_GET_ACCOUNT;
import static com.polo.rest.polo.constants.RestEndPoints.ACCOUNT_GET_ALL_ACCOUNTS;
import static com.polo.rest.polo.constants.RestEndPoints.ACCOUNT_UPDATE;
import static com.polo.rest.polo.constants.RestEndPoints.ACCOUNT_VALIDATOR;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.polo.rest.polo.dto.AccountDto;
import com.polo.rest.polo.dto.ParentsDto;
import com.polo.rest.polo.dto.PaymentDto;
import com.polo.rest.polo.exceptions.AccountException;
import com.polo.rest.polo.service.AccountService;

@RestController
public class AccountControllerImpl
{

    @Autowired
    private AccountService accountService;
    
    @RequestMapping("/")
    public String index() {
        return ResponseEntity.ok().build().toString();
    }
    
    @RequestMapping( value=ACCOUNT_CREATE, method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE )
    public String createAccount( @RequestBody(required=true) AccountDto newAccount) throws AccountException {
    	accountService.createAccount( newAccount );
    	/*
    	AccountDto accountDto1 = createDtoForTests(1);
    	AccountDto accountDto2 = createDtoForTests(2);
    	accountDto2.setParentsDtoList(null);
    	AccountDto accountDto3 = createDtoForTests(3);
    	AccountDto accountDto4 = createDtoForTests(4);
    	accountService.createAccount(accountDto1);
    	accountService.createAccount(accountDto2);
    	accountService.createAccount(accountDto3);
    	accountService.createAccount(accountDto4);
    	*/
    	return "saved: " + newAccount.toString(); 
    }

    @RequestMapping( value=ACCOUNT_GET_ACCOUNT, method=RequestMethod.GET )
    public AccountDto getAccount( @PathVariable(value="cardId", required=true) int cardId ) throws AccountException {
    	return accountService.getAccountByCardId( cardId );
    }
    
    @RequestMapping( value=ACCOUNT_GET_ALL_ACCOUNTS, method=RequestMethod.GET )
    public List<AccountDto> getAllAccounts() {
    	return accountService.getAllAccounts();
    }
    
    @RequestMapping( value=ACCOUNT_UPDATE )
    public String updateAccount( /*@PathVariable( value="cardID", required=true ) int cardId */) throws AccountException {
    	//TODO check cardID has not changed!
    	AccountDto accountDto = accountService.getAccountByCardId( 2 );
    	
    	accountDto.setName( "NEW Name" );
    	accountDto.setBirthday( "NEW Birthday" );
    	accountDto.setGender( "NEW Gender" );
    	
    	accountService.updateAccount( accountDto );
    	
        return "Updated: " + accountDto;
    }
    
    
    
    @RequestMapping(ACCOUNT_VALIDATOR)
    public ResponseEntity validateAccount(HttpServletResponse response) throws IOException {
    	
    	AccountDto accountDto = createDtoForTests(4578);
    	//accountDto.setName(null);
    	
//    	try {
//			//accountValidator.validateAccount(accountDto);
//		} catch (AccountException e) {
//			System.err.println( e.getMessage() );
//			response.sendError(HttpStatus.CONFLICT.value(), e.getMessage());
//		}
    	
        return new ResponseEntity<String>(accountDto.toString(), HttpStatus.CREATED);
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	private AccountDto createDtoForTests(int cardId) {
		AccountDto accountDto = new AccountDto();
    	accountDto.setName("AccountFILHO");
    	accountDto.setBirthday("birthday");
    	accountDto.setGender("Gender");
    	accountDto.setObservations("Observations");
    	accountDto.setPostalCode("postal");
    	accountDto.setSize("size");
    	accountDto.setLevel("level");
    	accountDto.setCardId(cardId);
    	
    	List<ParentsDto> parentsList = new ArrayList<>();
    	ParentsDto parents1 = new ParentsDto();
    	parents1.setName("PAI");
    	parents1.setEmail("emailPAI");
    	
    	ParentsDto parents2 = new ParentsDto();
    	parents2.setEmail("MAE");
    	parents2.setName("emailMAE");
    	
    	parentsList.add(parents1);
    	parentsList.add(parents2);
    	
    	accountDto.setParentsDtoList( parentsList );
    	//accountDto.setParentsDtoList( null );
		return accountDto;
	}
    
    
}
