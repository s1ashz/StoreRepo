package com.polo.rest.polo.controller;

import static com.polo.rest.polo.constants.RestEndPoints.ACCOUNT_AUTHENTICATE;
import static com.polo.rest.polo.constants.RestEndPoints.ACCOUNT_CREATE;
import static com.polo.rest.polo.constants.RestEndPoints.ACCOUNT_DELETE;
import static com.polo.rest.polo.constants.RestEndPoints.ACCOUNT_DELETE_ALL_DATABASE;
import static com.polo.rest.polo.constants.RestEndPoints.ACCOUNT_GET_ACCOUNT_BY_CARD_ID;
import static com.polo.rest.polo.constants.RestEndPoints.ACCOUNT_GET_ALL_ACCOUNTS;
import static com.polo.rest.polo.constants.RestEndPoints.ACCOUNT_LOGOUT;
import static com.polo.rest.polo.constants.RestEndPoints.ACCOUNT_UPDATE;
import static com.polo.rest.polo.constants.RestEndPoints.FILL_DATABASE;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
import com.polo.rest.polo.dto.EventDto;
import com.polo.rest.polo.dto.ParentsDto;
import com.polo.rest.polo.dto.PaymentDto;
import com.polo.rest.polo.entity.Payment;
import com.polo.rest.polo.exceptions.AccountException;
import com.polo.rest.polo.exceptions.EventException;
import com.polo.rest.polo.repository.PaymentRepository;
import com.polo.rest.polo.responses.AuthenticationJson;
import com.polo.rest.polo.responses.ResponseJson;
import com.polo.rest.polo.service.AccountService;
import com.polo.rest.polo.service.EventService;

@RestController
public class AccountControllerImpl
{
    //TODO DELETE THIS AFTER
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private EventService eventService;
    //TODO DELETE THIS AFTER

    @Autowired
    private AccountService accountService;
    
    @RequestMapping("/")
    public String index() {
        return ResponseEntity.ok().build().toString();
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
    public ResponseJson updateAccount( @RequestBody(required=true) AccountDto updateAccount ) throws AccountException {
        return accountService.updateAccount( updateAccount );
    }
    
    @RequestMapping( value=ACCOUNT_DELETE )
    public ResponseJson deleteAccount( @PathVariable( value="cardId", required=true ) int cardId ) throws AccountException {
    	return accountService.deleteAccount( cardId );
    }
    
    @RequestMapping( value=ACCOUNT_DELETE_ALL_DATABASE )
    public String deleteAllDatabase() throws AccountException {
        accountService.deleteAll();
        return "All Records Deleted";
    }
    
    @RequestMapping(ACCOUNT_AUTHENTICATE)
    public ResponseJson authenticateAccount( @RequestBody(required=true) AuthenticationJson auth ) throws AccountException {
        return accountService.authenticateAccount( auth );
    }
    
    @RequestMapping(ACCOUNT_LOGOUT)
    public ResponseJson logoutAccount( @RequestBody(required=true) AuthenticationJson auth ) throws AccountException {
        return accountService.logoutAccount( auth );
    }

    
    
    
    
    
    //FILL Database for tests
    
    
    private Payment createPaymentForTEsts(int cardId, int year, int monthIndex ) {
        Payment payment = new Payment();
        payment.setCardId( cardId );
        payment.setYear( year );
        payment.setAmmount( 20.00 );
        payment.setMonth( monthIndex );
        payment.setPaid( true );
        
        return payment;
    }
    
    @RequestMapping("/payments/fill")
    public String fillDatabasePayments() throws AccountException, EventException {
    	
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
        
        return "ok";
    	
    }
    
    
    @RequestMapping(FILL_DATABASE)
    public String fillDatabase() throws AccountException, EventException {
        
        
        
        AccountDto accountDto1 = createDtoForTests( "Joao", 1, "JoãoPai", "JoãoMae", "j.c.moreirapinto@gmail.com", "4876-468", createNewDateForTests(1992,5,25), "M", 934620715, "Senior", "size", "Very good developer");
        AccountDto accountDto2 = createDtoForTests( "Francisco", 2, "FranciscoPai", "FranciscoMae", "franciscomfilipe@hotmail.com", "4876-468", createNewDateForTests(1990, 7, 19), "M", 910773555, "Senior", "size", "back end master");
        AccountDto accountDto3 = createDtoForTests( "Pascal", 3, "PascalPai", "PascalMae", "pascal@gmail.com", "4876-468", createNewDateForTests(1984, 1, 25), "M", 912548741, "Junior", "size", "Party Leader");
        AccountDto accountDto4 = createDtoForTests( "Marco", 4, "MarcoPai", "MarcoMae", "marcorabta@gmail.com", "4876-468", createNewDateForTests(1974, 8, 12), "M", 915468234, "Juvenil", "size", "Team Leader / Dev Manager");

        accountService.createAccount(accountDto1);
        accountService.createAccount(accountDto2);
        accountService.createAccount(accountDto3);
        accountService.createAccount(accountDto4);
        
        //-------------------------
        
        String accountPrint = accountDto1.toString() + "\n" + 
        		accountDto2.toString() + "\n" + 
        		accountDto3.toString() + "\n" + 
        		accountDto4.toString();
        
        //for (Payment p : payList ) {
        	//accountPrint += p.toString() + "\n"; 
        //}
        
        //paymentRepository.saveAll( createPaymentDtoForTEsts( 1, 2015 ) );
        //paymentRepository.saveAll( createPaymentDtoForTEsts( 1, 2016 ) );
        //paymentRepository.saveAll( createPaymentDtoForTEsts( 1, 2017 ) );
        //paymentRepository.saveAll( createPaymentDtoForTEsts( 1, 2018 ) );
        /*paymentRepository.saveAll( createPaymentDtoForTEsts( 2, 2016 ) );
        paymentRepository.saveAll( createPaymentDtoForTEsts( 2, 2017 ) );
        paymentRepository.saveAll( createPaymentDtoForTEsts( 2, 2018 ) );
        paymentRepository.saveAll( createPaymentDtoForTEsts( 3, 2017 ) );
        paymentRepository.saveAll( createPaymentDtoForTEsts( 3, 2018 ) );
        paymentRepository.saveAll( createPaymentDtoForTEsts( 4, 2018 ) );
        */
        
        //https://regrasdoesporte.com.br/wp-content/uploads/2012/12/regras-polo-aquatico-natacao.jpg
        //https://pbs.twimg.com/media/DFsje9KXkAAtzVV.jpg
        
        
        eventService.createEvent( createEventDtoForTests( "Junior League", "https://regrasdoesporte.com.br/wp-content/uploads/2012/12/regras-polo-aquatico-natacao.jpg", "1", "Porto", "Jogo contra o Porto", "Juvenil", createNewDateForTests(2018, 10, 21) ) );
        eventService.createEvent( createEventDtoForTests( "Senior League", "https://pbs.twimg.com/media/DFsje9KXkAAtzVV.jpg", "1", "Lisboa", "Jogo contra Lisboa", "Juvenil", createNewDateForTests(2018, 10, 21) ) );
        
        return accountPrint + "\n\n";
    }
    
    private Date createNewDateForTests( int year, int month, int day ) {
        Calendar cal = Calendar.getInstance();
        cal.set( Calendar.YEAR, year );
        cal.set( Calendar.MONTH, month );
        cal.set( Calendar.DATE, day );
        cal.set( Calendar.HOUR_OF_DAY, 14 );
        cal.set( Calendar.MINUTE, 00 );
        return cal.getTime();
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
    
	private AccountDto createDtoForTests(
	        String name, 
	        int cardId, 
	        String parentName1, 
	        String parentName2, 
	        String email,
	        String postalCode,
	        Date birthday,
	        String gender,
	        int mobileNumber,
	        String level,
	        String size,
	        String observations ) {
	    
		AccountDto accountDto = new AccountDto();
    	accountDto.setName(name);
    	
    	accountDto.setBirthday( birthday );
    	accountDto.setGender( gender );
    	accountDto.setObservations( observations );
    	accountDto.setPostalCode( postalCode );
    	accountDto.setSize( size );
    	accountDto.setLevel( level );
    	accountDto.setCardId( cardId );
    	accountDto.setEmail( email );
    	accountDto.setAddress( name + "'s address" );
    	
    	List<ParentsDto> parentsList = new ArrayList<>();
    	ParentsDto parents1 = new ParentsDto();
    	parents1.setName(parentName1);
    	parents1.setEmail(parentName1 + "@gmail.com");
    	
    	ParentsDto parents2 = new ParentsDto();
    	parents2.setName(parentName1);
    	parents2.setEmail(parentName2 + "@gmail.com");
    	
    	parentsList.add(parents1);
    	parentsList.add(parents2);
    	
    	accountDto.setParents( parentsList );
		return accountDto;
	}
    
	private EventDto createEventDtoForTests(String name, String picture, String priority, String location, String content, String target, Date date) {
	    EventDto eventDto = new EventDto();
	    eventDto.setName( name );
	    eventDto.setPicture( picture );
	    eventDto.setPriority( priority );
	    eventDto.setLocation( location );
	    eventDto.setDate( date );
	    eventDto.setContent( content );
	    eventDto.setHome( "Porto" );
	    eventDto.setAway( "Benfica" );
	    List<Integer> homePlayers = new ArrayList<>();
	    homePlayers.add( 1 );
	    homePlayers.add( 3 );
	    
	    List<Integer> awayPlayers = new ArrayList<>();
	    awayPlayers.add( 2 );
	    awayPlayers.add( 4 );
	    
	    eventDto.setHomePlayers( homePlayers );
	    eventDto.setAwayPlayers( awayPlayers );
	    
	    List<Integer> homeCoaches = new ArrayList<>();
	    homeCoaches.add( 1 );
	    
	    List<Integer> awayCoaches = new ArrayList<>();
	    awayCoaches.add( 3 );
	    
	    List<String> refereesList = new ArrayList<>();
	    refereesList.add( "referee" );
	    
	    eventDto.setHomeCoaches( homeCoaches );
	    eventDto.setAwayCoaches( awayCoaches );
	    eventDto.setReferees( refereesList );
	    
	    
	    List<String> targetList = new ArrayList<>();
	    targetList.add( target );
	    eventDto.setTarget( targetList );
	    
	    return eventDto;
	}
	
	
	
	
}
