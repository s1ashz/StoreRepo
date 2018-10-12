package com.polo.rest.polo.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.polo.rest.polo.dao.EventDao;
import com.polo.rest.polo.entity.Event;
import com.polo.rest.polo.responses.ResponseJson;

import static com.polo.rest.polo.constants.Actions.*;

@Service
public class EventService
{
    
    @Autowired
    private EventDao eventDao;
    
    public ResponseJson createEvent( Event event ) {
        Long eventId = eventDao.createEvent( event );
        System.out.println( "IDDDD: " + eventId );
        return new ResponseJson( CREATE, true, eventId );
    }

    public Event getEvent( Long eventId ) {
        return eventDao.getEvent( eventId );
    }

}
