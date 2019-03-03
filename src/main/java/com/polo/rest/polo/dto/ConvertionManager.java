package com.polo.rest.polo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.polo.rest.polo.entity.Account;
import com.polo.rest.polo.entity.Event;
import com.polo.rest.polo.entity.Parent;
import com.polo.rest.polo.entity.Payment;
import com.polo.rest.polo.entity.Target;

public class ConvertionManager
{

    private static ConvertionManager convertionManagerInstance = null;
    private ConvertionManager() {}
    
    public static ConvertionManager getConvertionManager() {
        if ( null == convertionManagerInstance ) {
            convertionManagerInstance = new ConvertionManager();
        }
        return convertionManagerInstance;
    }
    
    public AccountDto convertAccountToDto( Account entityAccount) {
        AccountDto dtoAccount = new AccountDto();
        
        dtoAccount.setName( entityAccount.getName() );
        dtoAccount.setCardId( entityAccount.getCardId() );
        dtoAccount.setPostalCode( entityAccount.getPostalCode() );
        dtoAccount.setBirthday( entityAccount.getBirthday() );
        dtoAccount.setGender( entityAccount.getGender() );
        dtoAccount.setMobileNumber( entityAccount.getMobileNumber() );
        dtoAccount.setLevel( entityAccount.getLevel() );
        dtoAccount.setSize( entityAccount.getSize() );
        dtoAccount.setObservations( entityAccount.getObservations() );
        dtoAccount.setCc( entityAccount.isCc() );
        dtoAccount.setExam( entityAccount.isExam() );
        dtoAccount.setEnrolled( entityAccount.isEnrolled() );
        dtoAccount.setEmail( entityAccount.getEmail() );
        dtoAccount.setAddress( entityAccount.getAddress() );

        //dtoAccount.setParentsDtoList( convertParentsToDto( entityAccount.getParentsList() ) );
        
        return dtoAccount;
    }
    
    public List<ParentsDto> convertParentsToDto( List<Parent> entityParentsList ) {
    	List<ParentsDto> parentsDtoList = new ArrayList<>();
    	for ( Parent parent : entityParentsList  ) {
    		ParentsDto dtoParent = new ParentsDto();
    		dtoParent.setName( parent.getName() );
    		dtoParent.setEmail( parent.getEmail() );
    		dtoParent.setMobileNumber( parent.getMobileNumber() );
    		
    		parentsDtoList.add( dtoParent );
    	}
        return parentsDtoList;
    }
    
    public Account convertAccountToEntity( AccountDto dtoAccount) {
        Account entityAccount = new Account();
        
        entityAccount.setName( dtoAccount.getName() );
        entityAccount.setCardId( dtoAccount.getCardId() );
        entityAccount.setPostalCode( dtoAccount.getPostalCode() );
        entityAccount.setBirthday( dtoAccount.getBirthday() );
        entityAccount.setGender( dtoAccount.getGender() );
        entityAccount.setMobileNumber( dtoAccount.getMobileNumber() );
        entityAccount.setLevel( dtoAccount.getLevel() );
        entityAccount.setSize( dtoAccount.getSize() );
        entityAccount.setObservations( dtoAccount.getObservations() );
        entityAccount.setCc( dtoAccount.isCc() );
        entityAccount.setExam( dtoAccount.isExam() );
        entityAccount.setEnrolled( dtoAccount.isEnrolled() );
        entityAccount.setEmail( dtoAccount.getEmail() );
        entityAccount.setAddress( dtoAccount.getAddress() );
        entityAccount.setToken( "default" );

        return entityAccount;
    }
    
    public List<Parent> convertParentsDtoToEntity( List<ParentsDto> dtoParentsList, Account accountEntity ) {
    	List<Parent> parentsEntityList = new ArrayList<>();
    	if ( null != dtoParentsList ) {
	    	for ( ParentsDto parentDto : dtoParentsList  ) {
	    		Parent entityParents = new Parent();
	            entityParents.setName( parentDto.getName() );
	            entityParents.setEmail( parentDto.getEmail() );
	            entityParents.setMobileNumber( parentDto.getMobileNumber() );
	    		entityParents.setAccount( accountEntity );
	    		entityParents.setToken( "default" );
	            
	    		parentsEntityList.add( entityParents );
	    	}
    	}
        return parentsEntityList;
    }

    //PAYMENTS--------------

    public PaymentDto convertPaymentToDto( List<Payment> paymentEntityList, int cardId, int year ) {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setCardId( cardId );
        paymentDto.setYear( year );
        for (Payment payment : paymentEntityList ) {
            for (MonthPaymentsDto monthPayment : paymentDto.getMonthPayments() ) {
                if ( monthPayment.getMonth() == payment.getMonth() ) {
                    monthPayment.setValue( payment.getAmmount() );
                }
            }
        }
        return paymentDto;
    }
    
    public List<Payment> convertPaymentDtoToEntity( PaymentDto paymentDto ) {
        
        List<Payment> paymentList = new ArrayList<>();
        for ( MonthPaymentsDto monthPayment : paymentDto.getMonthPayments() ) {
            Payment paymentEntity = new Payment();
            paymentEntity.setCardId( paymentDto.getCardId() );
            paymentEntity.setYear( paymentDto.getYear() );
            paymentEntity.setMonth( monthPayment.getMonth() );
            if ( 0.00 != monthPayment.getValue() ) {
                paymentEntity.setAmmount( monthPayment.getValue() );
                paymentEntity.setPaid( true );
            }
            paymentList.add( paymentEntity );
        }
        
        return paymentList;
    }
    
    public Event convertEventDtoToEvent( EventDto eventDto ) {
        Event eventEntity = new Event();
        eventEntity.setName( eventDto.getName() );
        eventEntity.setPicture( eventDto.getPicture() );
        eventEntity.setPriority( eventDto.getPriority() );
        eventEntity.setLocation( eventDto.getLocation() );
        eventEntity.setDate( eventDto.getDate() );
        eventEntity.setContent( eventDto.getContent() );
        
        eventEntity.setGame( eventDto.isGame() );
        eventEntity.setHome( eventDto.getHome() );
        eventEntity.setAway( eventDto.getAway() );
        eventEntity.setReferees( eventDto.getReferees() );
        
        return eventEntity;
    }
    
    public List<Target> convertEventDtoTargetToTargetEntity( List<String> targetList, Event eventEntity ) {
        List<Target> targetEntityList = new ArrayList<>();
        for ( String targetString : targetList ) {
            Target targetEntity = new Target();
            targetEntity.setTarget( targetString );
            targetEntity.setEvent( eventEntity );
            targetEntityList.add( targetEntity );
        }
        return targetEntityList;
    }

    public EventDto convertEventToEventDto( Event event ) {
        EventDto eventDto = new EventDto();
        eventDto.setId( event.getId() );
        eventDto.setName( event.getName() );
        eventDto.setPicture( event.getPicture() );
        eventDto.setPriority( event.getPriority() );
        eventDto.setLocation( event.getLocation() );
        eventDto.setDate( event.getDate() );
        eventDto.setContent( event.getContent() );
        
        eventDto.setHome( event.getHome() );
        eventDto.setAway( event.getAway() );
        eventDto.setGame( event.isGame() );
        
        List<Integer> homePlayersDto = new ArrayList<>();
        for ( Account homePlayerEntity : event.getHomePlayers() ) {
        	homePlayersDto.add( homePlayerEntity.getCardId() );
        }
        
        List<Integer> awayPlayersDto = new ArrayList<>();
        for ( Account awayPlayerEntity : event.getAwayPlayers() ) {
        	awayPlayersDto.add( awayPlayerEntity.getCardId() );
        }
        
        List<Integer> homeCoachesDto = new ArrayList<>();
        for ( Account homeCoachesEntity : event.getHomeCoaches() ) {
        	homeCoachesDto.add( homeCoachesEntity.getCardId() );
        }

        List<Integer> awayCoachesDto = new ArrayList<>();
        for ( Account awayCoachesEntity : event.getAwayCoaches() ) {
        	awayCoachesDto.add( awayCoachesEntity.getCardId() );
        }
        
        List<String> refereesList = new ArrayList<>();
        for ( String referee : event.getReferees() ) {
        	refereesList.add( referee );
        }
        
	    eventDto.setHomePlayers( homePlayersDto );
	    eventDto.setAwayPlayers( awayPlayersDto );
	    eventDto.setHomeCoaches( homeCoachesDto );
	    eventDto.setAwayCoaches( awayCoachesDto );	    
	    eventDto.setReferees( refereesList );
	    
        return eventDto;
    }
    
    public List<String> convertEventTargetToTargetDto( List<Target> targetList ) {
        List<String> targetDtoList = new ArrayList<>();
        for ( Target targetEntity : targetList ) {
            String targetString = targetEntity.getTarget();
            targetDtoList.add( targetString );
        }
        return targetDtoList;
    }
    
}
