package com.polo.rest.polo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.polo.rest.polo.entity.Event;
import com.polo.rest.polo.repository.EventRepository;

@Repository
public class EventDao
{

    @Autowired
    private EventRepository eventRepository;
    
    public Long createEvent( Event event ) {
        Event eventPersisted = eventRepository.save( event );
        return eventPersisted.getId();
    }
    
    public Event getEvent( Long eventId ) {
        return eventRepository.findById( eventId );
    }

}
