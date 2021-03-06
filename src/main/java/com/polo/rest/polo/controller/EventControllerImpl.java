package com.polo.rest.polo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polo.rest.polo.dto.EventDto;
import com.polo.rest.polo.entity.Event;
import com.polo.rest.polo.exceptions.AccountException;
import com.polo.rest.polo.exceptions.EventException;
import com.polo.rest.polo.responses.ResponseJson;
import com.polo.rest.polo.service.EventService;

import static com.polo.rest.polo.constants.RestEndPoints.*;

import java.util.List;

@RestController
public class EventControllerImpl
{
    
    @Autowired
    private EventService eventService;
    
    @RequestMapping( EVENT_CREATE )
    public ResponseJson createEvent( @RequestBody( required=true ) EventDto eventDto ) throws EventException {
        return eventService.createEvent( eventDto );
    }
    
    @RequestMapping( EVENT_GET ) 
    public EventDto getEvent( @PathVariable(value="eventId", required=true ) Long eventId ) throws EventException {
        return eventService.getEvent( eventId );
    }
    
    @RequestMapping( EVENT_GET_ALL )
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents();
    }
    
    @RequestMapping( EVENT_GET_ALL_BY_CARD_ID )
    public List<EventDto> getEventsByCardId( @PathVariable(value="cardId", required=true ) int cardId) {
        return eventService.getEventsByCardId( cardId );
    }
    
    @RequestMapping( EVENT_DELETE_BY_ID ) 
    public ResponseJson deleteEvent( @PathVariable(value="id", required=true ) int id ) throws EventException {
        return eventService.deleteEventById( id );
    }
    
    @RequestMapping( EVENT_UPDATE )
    public ResponseJson updateEvent( @RequestBody( required=true ) EventDto eventDto ) throws EventException {
        return eventService.updateEvent( eventDto );
    }


}
