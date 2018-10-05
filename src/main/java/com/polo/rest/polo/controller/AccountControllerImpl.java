package com.polo.rest.polo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.polo.rest.polo.dto.AccountDto;
import com.polo.rest.polo.dto.ConvertionManager;
import com.polo.rest.polo.dto.ParentsDto;
import com.polo.rest.polo.dto.PaymentDto;
import com.polo.rest.polo.entity.Account;
import com.polo.rest.polo.exceptions.AccountException;
import com.polo.rest.polo.service.AccountDao;
import com.polo.rest.polo.validators.AccountValidator;

import static com.polo.rest.polo.constants.RestEndPoints.*;

@RestController
public class AccountControllerImpl
{

    @Autowired
    private AccountValidator accountValidator;
    
    @Autowired
    private AccountDao accountDao;
    
    @RequestMapping("/")
    public String index() {
        
        return ResponseEntity.ok().build().toString();
    }

    @RequestMapping(ACCOUNT_VALIDATOR)
    public ResponseEntity validateAccount(HttpServletResponse response) throws IOException {
    	
    	AccountDto accountDto = createDtoForTests(4578);
    	//accountDto.setName(null);
    	
    	try {
			accountValidator.validateAccount(accountDto);
		} catch (AccountException e) {
			System.err.println( e.getMessage() );
			response.sendError(HttpStatus.CONFLICT.value(), e.getMessage());
		}
    	
        return new ResponseEntity<String>(accountDto.toString(), HttpStatus.CREATED);
    }

    @RequestMapping( value=ACCOUNT_GET, method=RequestMethod.GET )
    public Account getAccount( @PathVariable(value="cardId", required=true) int cardId ) {
    	Account accountEntity = accountDao.getAccountByCardId(cardId);
        return accountEntity;
    }
    
    @RequestMapping(ACCOUNT_CREATE)
    public String createAccount() {
    	
    	AccountDto accountDto1 = createDtoForTests(11);
    	AccountDto accountDto2 = createDtoForTests(22);
    	AccountDto accountDto3 = createDtoForTests(33);
    	AccountDto accountDto4 = createDtoForTests(44);
    	
    	Account account1 = ConvertionManager.getConvertionManager().convertAccountToEntity( accountDto1 );
    	Account account2 = ConvertionManager.getConvertionManager().convertAccountToEntity( accountDto2 );
    	Account account3 = ConvertionManager.getConvertionManager().convertAccountToEntity( accountDto3 );
    	Account account4 = ConvertionManager.getConvertionManager().convertAccountToEntity( accountDto4 );
    	
    	accountDao.createAccount(account1);
    	accountDao.createAccount(account2);
    	accountDao.createAccount(account3);
    	accountDao.createAccount(account4);
    	
        return "saved: " + account1.toString(); 
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	private AccountDto createDtoForTests(int cardId) {
		AccountDto accountDto = new AccountDto();
    	accountDto.setName("puta");
    	accountDto.setBirthday("cona");
    	accountDto.setGender("Gender");
    	accountDto.setObservations("Observations");
    	accountDto.setPostalCode("postal");
    	accountDto.setSize("size");
    	accountDto.setLevel("level");
    	accountDto.setCardId(cardId);
    	
    	List<ParentsDto> parentsList = new ArrayList<>();
    	ParentsDto parents1 = new ParentsDto();
    	parents1.setName("hey");
    	parents1.setEmail("email");
    	
    	ParentsDto parents2 = new ParentsDto();
    	parents2.setEmail("sdf");
    	parents2.setName("df");
    	
    	parentsList.add(parents1);
    	parentsList.add(parents2);
    	
    	
    	parentsList.add(parents1);
    	parentsList.add(parents2);
    	accountDto.setParentsDtoList( parentsList );
    	//accountDto.setParentsDtoList( null );
		return accountDto;
	}
    
    
}
