package com.polo.rest.polo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.polo.rest.polo.entity.Event;
import com.polo.rest.polo.exceptions.EventException;
import com.polo.rest.polo.repository.EventRepository;

import static com.polo.rest.polo.constants.ExceptionMessages.*;

@Repository
public class EventDao
{

    @Autowired
    private EventRepository eventRepository;
    
    public Long createEvent( Event event ) throws EventException {
        Event eventPersisted = eventRepository.save( event );
        if ( 0 == eventPersisted.getId() ) throw new EventException( EXCEPTION_EVENT_NOT_CREATED + event.getName() ); 
        return eventPersisted.getId();
    }
    
    public Event getEvent( Long eventId ) throws EventException {
        Optional<Event> eventOp = eventRepository.findById( eventId );
        if (!eventOp.isPresent() ) throw new EventException( EXCEPTION_EVENT_NOT_EXISTS );
        return eventOp.get();
    }

    public List<Event> getAllEvents() {
        return (List<Event>) eventRepository.findAll();
    }

//    public List<Event> getEventsByTarget( String target ) {
//        return eventRepository.getByTarget( target );
//    }

    public void deleteEventById( long id ) {
        eventRepository.deleteById( id );
    }

    public void updateEvent( Event event ) {
        eventRepository.save( event );
    }

    public boolean checkEventExists( long id ) {
        return eventRepository.existsById( id );
    }

}
