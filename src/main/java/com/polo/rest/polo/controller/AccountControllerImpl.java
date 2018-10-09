package com.polo.rest.polo.controller;

import static com.polo.rest.polo.constants.RestEndPoints.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.polo.rest.polo.dto.AccountDto;
import com.polo.rest.polo.dto.ConvertionManager;
import com.polo.rest.polo.dto.ParentsDto;
import com.polo.rest.polo.dto.PaymentDto;
import com.polo.rest.polo.entity.Payment;
import com.polo.rest.polo.exceptions.AccountException;
import com.polo.rest.polo.repository.PaymentRepository;
import com.polo.rest.polo.responses.ResponseJson;
import com.polo.rest.polo.exceptions.AccountException;
import com.polo.rest.polo.service.AccountService;

@RestController
public class AccountControllerImpl
{
    //TODO DELETE THIS AFTER
    @Autowired
    private PaymentRepository paymentRepository;
    //TODO DELETE THIS AFTER

    @Autowired
    private AccountService accountService;
    
    @RequestMapping("/")
    public String index() {
        return ResponseEntity.ok().build().toString();
    }
    
    private Payment createPaymentForTEsts(int cardId, int year, String month) {
        Payment payment = new Payment();
        payment.setCardId( cardId );
        payment.setYear( year );
        payment.setAmmount( 20.00 );
        payment.setMonth( month );
        payment.setPaid( true );
        
        return payment;
    }

    @RequestMapping( value=ACCOUNT_CREATE, method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE )
    public ResponseJson createAccount( @RequestBody(required=true) AccountDto newAccount ) throws AccountException {
    	return accountService.createAccount( newAccount );
    }

    @RequestMapping( value=ACCOUNT_GET_ACCOUNT_BY_CARD_ID, method=RequestMethod.GET )
    public AccountDto getAccount( @PathVariable(value="cardId", required=true) int cardId ) throws AccountException {
    	return accountService.getAccountByCardId( cardId );
    }
    
    @RequestMapping( value=ACCOUNT_GET_ALL_ACCOUNTS, method=RequestMethod.GET )
    public List<AccountDto> getAllAccounts() {
    	return accountService.getAllAccounts();
    }
    
    @RequestMapping( value=ACCOUNT_UPDATE )
    public String updateAccount( @RequestBody(required=true) AccountDto newAccount ) throws AccountException {
    	accountService.updateAccount( newAccount );
        return "Updated: " + newAccount;
    }
    
    @RequestMapping( value=ACCOUNT_DELETE_ALL_DATABASE )
    public String deleteAllDatabase() throws AccountException {
        accountService.deleteAll();
        return "All Records Deleted";
    }
    
    @RequestMapping(ACCOUNT_VALIDATOR)
    public ResponseEntity validateAccount(HttpServletResponse response) throws IOException {
    	
    	//AccountDto accountDto = createDtoForTests(4578);
    	//accountDto.setName(null);
    	
//    	try {
//			//accountValidator.validateAccount(accountDto);
//		} catch (AccountException e) {
//			System.err.println( e.getMessage() );
//			response.sendError(HttpStatus.CONFLICT.value(), e.getMessage());
//		}
    	
        //return new ResponseEntity<String>(accountDto.toString(), HttpStatus.CREATED);
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
    
    
    
    
    
    
    @RequestMapping(FILL_DATABASE)
    public String fillDatabase() throws AccountException {
        
        AccountDto accountDto1 = createDtoForTests("Joao", 1 , "Pai do Joao", "Mae do Joao");
        AccountDto accountDto2 = createDtoForTests("Francisco", 2, "Pai do xico", "Mae do xico");
        AccountDto accountDto3 = createDtoForTests("Marco de Boss", 3, "Satanas", "No record");
        AccountDto accountDto4 = createDtoForTests("Mordekaiser", 4, "Urgot", "Ashe");
        accountService.createAccount(accountDto1);
        accountService.createAccount(accountDto2);
        accountService.createAccount(accountDto3);
        accountService.createAccount(accountDto4);
        
        //-------------------------
        
        String accountPrint = accountDto1.toString() + "\n" + 
        		accountDto2.toString() + "\n" + 
        		accountDto3.toString() + "\n" + 
        		accountDto4.toString() + "\n";
        
        //for (Payment p : payList ) {
        	//accountPrint += p.toString() + "\n"; 
        //}
        
        paymentRepository.saveAll( createPaymentDtoForTEsts( 1, 2015 ) );
        paymentRepository.saveAll( createPaymentDtoForTEsts( 1, 2016 ) );
        paymentRepository.saveAll( createPaymentDtoForTEsts( 1, 2017 ) );
        paymentRepository.saveAll( createPaymentDtoForTEsts( 1, 2018 ) );
        paymentRepository.saveAll( createPaymentDtoForTEsts( 2, 2016 ) );
        paymentRepository.saveAll( createPaymentDtoForTEsts( 2, 2017 ) );
        paymentRepository.saveAll( createPaymentDtoForTEsts( 2, 2018 ) );
        paymentRepository.saveAll( createPaymentDtoForTEsts( 3, 2017 ) );
        paymentRepository.saveAll( createPaymentDtoForTEsts( 3, 2018 ) );
        paymentRepository.saveAll( createPaymentDtoForTEsts( 4, 2018 ) );
        
        return accountPrint;
    }
    
    private List<Payment> createPaymentDtoForTEsts( int cardId, int year ) {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setYear( year );
        paymentDto.setCardId( cardId );
        paymentDto.getMonthPayments().get( 0 ).setValue( 20.00 );
        paymentDto.getMonthPayments().get( new Random().nextInt( 11 ) ).setValue( 20.00 );
        paymentDto.getMonthPayments().get( new Random().nextInt( 11 ) ).setValue( 20.00 );
        paymentDto.getMonthPayments().get( new Random().nextInt( 11 ) ).setValue( 20.00 );
        paymentDto.getMonthPayments().get( new Random().nextInt( 11 ) ).setValue( 20.00 );
        paymentDto.getMonthPayments().get( new Random().nextInt( 11 ) ).setValue( 20.00 );
        
        return ConvertionManager.getConvertionManager().convertPaymentDtoToEntity( paymentDto );
    }
    
	private AccountDto createDtoForTests(String name, int cardId, String parentName1, String parentName2) {
		AccountDto accountDto = new AccountDto();
    	accountDto.setName(name);
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.set( Calendar.YEAR, 2017 );
    	calendar.set( 1990, 5, 19 );
    	accountDto.setBirthday( new Date(2017,5,19) );
    	accountDto.setGender("M");
    	accountDto.setObservations("Observations");
    	accountDto.setPostalCode("postal");
    	accountDto.setSize("size");
    	accountDto.setLevel("level");
    	accountDto.setCardId(cardId);
    	accountDto.setEmail( "Email" );
    	accountDto.setAddress( "address" );
    	
    	List<ParentsDto> parentsList = new ArrayList<>();
    	ParentsDto parents1 = new ParentsDto();
    	parents1.setName(parentName1);
    	parents1.setEmail("emailPAI");
    	
    	ParentsDto parents2 = new ParentsDto();
    	parents2.setEmail(parentName2);
    	parents2.setName("emailMAE");
    	
    	parentsList.add(parents1);
    	parentsList.add(parents2);
    	
    	accountDto.setParents( parentsList );
    	//accountDto.setParentsDtoList( null );
		return accountDto;
	}
    
    
}
