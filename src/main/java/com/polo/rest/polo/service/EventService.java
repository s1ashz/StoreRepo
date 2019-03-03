package com.polo.rest.polo.service;

import static com.polo.rest.polo.constants.Actions.CREATE;
import static com.polo.rest.polo.constants.Actions.DELETE;
import static com.polo.rest.polo.constants.Actions.UPDATE;
import static com.polo.rest.polo.constants.ExceptionMessages.EXCEPTION_EVENT_NOT_EXISTS;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polo.rest.polo.dao.AccountDao;
import com.polo.rest.polo.dao.EventDao;
import com.polo.rest.polo.dao.TargetDao;
import com.polo.rest.polo.dto.ConvertionManager;
import com.polo.rest.polo.dto.EventDto;
import com.polo.rest.polo.entity.Account;
import com.polo.rest.polo.entity.Event;
import com.polo.rest.polo.entity.Target;
import com.polo.rest.polo.exceptions.EventException;
import com.polo.rest.polo.firebase.FirebaseNotification;
import com.polo.rest.polo.responses.ResponseJson;
import com.polo.rest.polo.validators.EventValidator;

@Service
public class EventService
{
//        String deviceToken = "fIKiGSdq0J0:APA91bHtmdzIoawg6bHeGXdfcIprI4B9CG6YM-LuzDrn64EHYStS6ByobvgeiOdCBqbC1NWNUt6rr3xzW902AiD0RSzmtmwezof94ygS2_aFuk7M-p5JrTpjNwPmY3C0l7jtVWCOps9j";
//        String tokenJonny = "fQifALzSnaE:APA91bGreU3WKUeTzLhmNvwVvIcwcKVeaAl9JdQ6z-nKuSoXaUtMpGIArdYoXROXZYs4WMcQHR8WuktglRtLHH_dBxvt9WyQ7kI3NAkdop3BjWO29bkJik-38iFznjt9sz4OKa-2T4W7";
//        String tokenJonnyExpirado = "enG6OnFVLzo:APA91bHSiu3sZ5tO0QzmlVTLIMS8gf5yUjqh20hM4T3yhoyzDU2aiP715u22c_UhU_X6uqGCUe7V9yXN702vbDhOVsb4_tnitMy_gQrwbty6NBcjjOBZYtSLNZiunswjmfkM8GOQx0If";
//        
//        String title = "Pro title of notif";
//        String body = "Body??";
//        int eventId1 = 2;
    
    @Autowired
    private EventValidator eventValidator;
    
    @Autowired
    private EventDao eventDao;
    
    @Autowired
    private AccountDao accountDao;
    
    @Autowired
    private TargetDao targetDao;
    
    @Autowired
    private FirebaseNotification firebaseNotification;
    
    private ConvertionManager convertionManager;
    
    public EventService() {
    	convertionManager = ConvertionManager.getConvertionManager();
	}
    
    public ResponseJson createEvent( EventDto eventDto ) throws EventException {
        eventValidator.validateEvent( eventDto );
        Event eventEntity = convertionManager.convertEventDtoToEvent( eventDto );
        
        System.out.println( "************************" );
        List<Account> homePlayersFromDatabase = accountDao.getAccountsByCardIdList( eventDto.getHomePlayers() );
        List<Account> awayPlayersFromDatabase = accountDao.getAccountsByCardIdList( eventDto.getAwayPlayers() );
        List<Account> homeCoachesFromDatabase = accountDao.getAccountsByCardIdList( eventDto.getHomeCoaches() );
        List<Account> awayCoachesFromDatabase = accountDao.getAccountsByCardIdList( eventDto.getAwayCoaches() );
        
        System.out.println( "id: " +eventEntity.getId() );
        
        
        eventEntity.setHomePlayers( homePlayersFromDatabase );
        eventEntity.setAwayPlayers( awayPlayersFromDatabase );
        eventEntity.setHomeCoaches( homeCoachesFromDatabase );
        eventEntity.setAwayCoaches( awayCoachesFromDatabase );
        System.out.println( "************************" );
        
        Long eventId = eventDao.createEvent( eventEntity );
        List<Target> targetEntityList = convertionManager.convertEventDtoTargetToTargetEntity( eventDto.getTarget(), eventEntity );
        targetDao.createTarget( targetEntityList );
        
        List<String> tokenList = getTokenListFromDatabase(targetEntityList);
        
        sendFirebaseNotification( tokenList, eventDto.getName(), eventId);
    
        return new ResponseJson( CREATE, true, eventId );
    }
    
    public EventDto getEvent( Long eventId ) throws EventException {
        if ( !checkEventExists( eventId ) ) throw new EventException( EXCEPTION_EVENT_NOT_EXISTS + eventId );
        Event event = eventDao.getEvent( eventId );
        
        EventDto eventDto = convertionManager.convertEventToEventDto( event );
        eventDto.setId( eventId );
        List<Target> targetEntityList = targetDao.findTargetByEvent( event );
        eventDto.setTarget( convertionManager.convertEventTargetToTargetDto( targetEntityList ) );

        return eventDto;
    }

    public List<EventDto> getAllEvents() {
        List<Event> eventEntityList = eventDao.getAllEvents();
        List<EventDto> eventDtoList = getEventDtoListFromDatabase( eventEntityList );
        return eventDtoList;
    }

    public List<EventDto> getEventsByCardId( int cardId ) {
        String target = accountDao.getAccountLevelByCardId( cardId );
        List<Target> targetEntityList = targetDao.findByTarget( target );
        List<EventDto> eventEntityList = createEventDtoList( targetEntityList );
        return eventEntityList;
    }

    public ResponseJson deleteEventById( int id ) throws EventException {
        if ( !checkEventExists( id ) ) throw new EventException( EXCEPTION_EVENT_NOT_EXISTS + id );
        Event eventEntity = eventDao.getEvent( Long.valueOf( id ) );
        List<Target> targetList = targetDao.findTargetByEvent( eventEntity );
        targetDao.deleteTargetList( targetList );
        eventDao.deleteEventById( id );
        return new ResponseJson( DELETE, true, Long.valueOf( id ) );
    }

    public ResponseJson updateEvent( EventDto eventDto ) throws EventException {
        if ( !checkEventExists( eventDto.getId() ) ) throw new EventException( EXCEPTION_EVENT_NOT_EXISTS + eventDto.getId() );
        eventValidator.validateEvent( eventDto );
        Event eventEntity = convertionManager.convertEventDtoToEvent( eventDto );
        eventEntity.setId( eventDto.getId() );
        
        //Update existing event in database
        List<Target> targetEntityList = convertionManager.convertEventDtoTargetToTargetEntity( eventDto.getTarget(), eventEntity );
        eventDao.updateEvent( eventEntity );
        
        //Get and delete old event target
        List<Target> oldtargetEntityList = targetDao.findTargetByEvent( eventEntity );
        targetDao.deleteTargetList( oldtargetEntityList );
        
        //Insert new event target
        targetDao.createTarget( targetEntityList );
        
        return new ResponseJson( UPDATE, true, eventDto.getId() );
    }
    
    private void sendFirebaseNotification( List<String> tokenList, String eventName, Long eventId ) {
        for ( String token : tokenList ) {
            firebaseNotification.sendPushNotification(token, "New Event", eventName, eventId);
        }
    }

    private List<String> getTokenListFromDatabase( List<Target> targetEntityList ) {
        List<String> tokenList = new ArrayList<>();
        for ( Target targetEntity : targetEntityList ) {
            tokenList.addAll( accountDao.getAccountTokenByLevel( targetEntity.getTarget() ) );
        }
        return tokenList;
    }
    
    private List<EventDto> createEventDtoList( List<Target> targetEntityList ) {
        List<EventDto> eventDtoList = new ArrayList<>();
        for ( Target targetEntity : targetEntityList ) {
            EventDto eventDto = getEventDtoFromDatabase( targetEntity.getEvent() );
            eventDtoList.add( eventDto );
        }
        return eventDtoList;
    }
    
    private List<EventDto> getEventDtoListFromDatabase( List<Event> eventEntityList ) {
        List<EventDto> eventDtoList = new ArrayList<>();
        for ( Event entityEvent : eventEntityList ) {
            EventDto eventDto = getEventDtoFromDatabase( entityEvent );
            eventDtoList.add( eventDto );
        }
        return eventDtoList;
    }
    
    private EventDto getEventDtoFromDatabase( Event entityEvent ) {
        EventDto eventDto = convertionManager.convertEventToEventDto( entityEvent ); 
        List<Target> eventTargetList = targetDao.findTargetByEvent( entityEvent );
        eventDto.setTarget( convertionManager.convertEventTargetToTargetDto( eventTargetList ) );
        return eventDto;
    }

    private boolean checkEventExists( long id ) {
        return eventDao.checkEventExists( id );
    }

}
