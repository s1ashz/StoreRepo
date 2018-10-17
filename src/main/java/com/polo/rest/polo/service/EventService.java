package com.polo.rest.polo.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.polo.rest.polo.dao.AccountDao;
import com.polo.rest.polo.dao.EventDao;
import com.polo.rest.polo.dao.TargetDao;
import com.polo.rest.polo.dto.ConvertionManager;
import com.polo.rest.polo.dto.EventDto;
import com.polo.rest.polo.entity.Event;
import com.polo.rest.polo.entity.Target;
import com.polo.rest.polo.exceptions.AccountException;
import com.polo.rest.polo.exceptions.EventException;
import com.polo.rest.polo.firebase.FirebaseNotification;
import com.polo.rest.polo.responses.ResponseJson;
import com.polo.rest.polo.validators.EventValidator;

import static com.polo.rest.polo.constants.Actions.*;
import static com.polo.rest.polo.constants.ExceptionMessages.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService
{
    
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
    
    private ConvertionManager convertionManager = ConvertionManager.getConvertionManager();
    
    public ResponseJson createEvent( EventDto eventDto ) throws EventException {
        
        eventValidator.validateEvent( eventDto );
        Event eventEntity = convertionManager.convertEventDtoToEvent( eventDto );
        Long eventId = eventDao.createEvent( eventEntity );
        List<Target> targetEntityList = convertionManager.convertEventDtoTargetToTargetEntity( eventDto.getTarget(), eventEntity );
        targetDao.createTarget( targetEntityList );
        
        String deviceToken = "cnebGj_bVGk:APA91bE_GjTEiUzuTxaQnazwR7Uj6Ewyz23XwTtkMYsq7PhmboitNtpNE_Xw1k0AFeF7LQRjvk8ZsyGkUz12uuTqT_OzmERbL0DUGRkM5Opjt1KrNRrqWxPmxgdMsRff6aITeRgmqq0t";
        String tokenJonny = "fQifALzSnaE:APA91bGreU3WKUeTzLhmNvwVvIcwcKVeaAl9JdQ6z-nKuSoXaUtMpGIArdYoXROXZYs4WMcQHR8WuktglRtLHH_dBxvt9WyQ7kI3NAkdop3BjWO29bkJik-38iFznjt9sz4OKa-2T4W7";
        String tokenJonnyExpirado = "enG6OnFVLzo:APA91bHSiu3sZ5tO0QzmlVTLIMS8gf5yUjqh20hM4T3yhoyzDU2aiP715u22c_UhU_X6uqGCUe7V9yXN702vbDhOVsb4_tnitMy_gQrwbty6NBcjjOBZYtSLNZiunswjmfkM8GOQx0If";
        
        String title = "Pro title of notif";
        String body = "Body??";
        int eventId1 = 2;
        
        
        FirebaseNotification.sendPushNotification(deviceToken, title, body, eventId);
    
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

    public List<Event> getAllEvents() {
        //TODO CHANGE THIS TO DTO EVENTS :/
        return eventDao.getAllEvents();
    }

    public List<EventDto> getEventsByCardId( int cardId ) {
        String target = accountDao.getAccountLevelByCardId( cardId );
        List<Target> targetEntityList = targetDao.findByTarget( target );
        List<EventDto> eventEntityList = createEventDtoList( targetEntityList );
        return eventEntityList;
    }

    private List<EventDto> createEventDtoList( List<Target> targetEntityList ) {
        List<EventDto> eventList = new ArrayList<>();
        for ( Target targetEntity : targetEntityList ) {
            EventDto eventDto = convertionManager.convertEventToEventDto( targetEntity.getEvent() );
            List<Target> eventTargetList = targetDao.findTargetByEvent( targetEntity.getEvent() );
            eventDto.setTarget( convertionManager.convertEventTargetToTargetDto( eventTargetList ) );
            eventList.add( eventDto );
        }
        return eventList;
    }

    public ResponseJson deleteEventById( int id ) throws EventException {
        if ( !checkEventExists( id ) ) throw new EventException( EXCEPTION_EVENT_NOT_EXISTS + id );
        eventDao.deleteEventById( id );
        return new ResponseJson( DELETE, true, Long.valueOf( id ) );
    }

    public ResponseJson updateEvent( EventDto eventDto ) throws EventException {
        if ( !checkEventExists( eventDto.getId() ) ) throw new EventException( EXCEPTION_EVENT_NOT_EXISTS + eventDto.getId() );
        eventValidator.validateEvent( eventDto );
        Event eventEntity = convertionManager.convertEventDtoToEvent( eventDto );
        eventEntity.setId( eventDto.getId() );
        
        //Epdate existing event in database
        List<Target> targetEntityList = convertionManager.convertEventDtoTargetToTargetEntity( eventDto.getTarget(), eventEntity );
        eventDao.updateEvent( eventEntity );
        
        //Get and delete old event target
        List<Target> oldtargetEntityList = targetDao.findTargetByEvent( eventEntity );
        targetDao.deleteTargetList( oldtargetEntityList );
        
        //Insert new event target
        targetDao.createTarget( targetEntityList );
        
        return new ResponseJson( UPDATE, true, eventDto.getId() );
    }

    private boolean checkEventExists( long id ) {
        return eventDao.checkEventExists( id );
    }

}
