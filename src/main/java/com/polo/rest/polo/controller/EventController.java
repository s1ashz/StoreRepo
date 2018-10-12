package com.polo.rest.polo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polo.rest.polo.entity.Event;
import com.polo.rest.polo.responses.ResponseJson;
import com.polo.rest.polo.service.EventService;

import static com.polo.rest.polo.constants.RestEndPoints.*;

@RestController
public class EventController
{
    
    @Autowired
    private EventService eventService;
    
    @RequestMapping( EVENT_CREATE )
    private ResponseJson createEvent( @RequestBody( required=true ) Event event ) {
        //Event event = new Event();
        //event.setName( "super event" );
        //event.setPriority( "HIGHHHH MODDAUFKCKER" );
        return eventService.createEvent( event );
    }
    
    @RequestMapping( EVENT_GET ) 
    private Event getEvent( @PathVariable(value="eventId", required=true ) Long eventId ) {
        return eventService.getEvent( eventId );
    }
    
    
    
}
