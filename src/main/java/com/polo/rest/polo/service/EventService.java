package com.polo.rest.polo.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.polo.rest.polo.dao.AccountDao;
import com.polo.rest.polo.dao.EventDao;
import com.polo.rest.polo.entity.Event;
import com.polo.rest.polo.exceptions.EventException;
import com.polo.rest.polo.responses.ResponseJson;

import static com.polo.rest.polo.constants.Actions.*;
import static com.polo.rest.polo.constants.ExceptionMessages.*;

import java.util.List;

@Service
public class EventService
{
    
    @Autowired
    private EventDao eventDao;
    
    @Autowired
    private AccountDao accountDao;
    
    public ResponseJson createEvent( Event event ) {
        Long eventId = eventDao.createEvent( event );
        return new ResponseJson( CREATE, true, eventId );
    }

    public Event getEvent( Long eventId ) throws EventException {
        return eventDao.getEvent( eventId );
    }

    public List<Event> getAllEvents() {
        return eventDao.getAllEvents();
    }

    public List<Event> getEventsByCardId( int cardId ) {
        String target = accountDao.getAccountLevelByCardId( cardId );
        return eventDao.getEventsByCardId( target );
    }

    public ResponseJson deleteEventById( int id ) throws EventException {
        if ( !checkEventExists( id ) ) throw new EventException( EXCEPTION_EVENT_NOT_EXISTS + id );
        return new ResponseJson( DELETE, true, Long.valueOf( id ) );
    }

    public ResponseJson updateEvent( Event event ) throws EventException {
        if ( !checkEventExists( event.getId() ) ) throw new EventException( EXCEPTION_EVENT_NOT_EXISTS + event.getId() );
        eventDao.updateEvent( event );
        return new ResponseJson( UPDATE, true, event.getId() );
    }

    private boolean checkEventExists( long id ) {
        return eventDao.checkEventExists( id );
    }

}
