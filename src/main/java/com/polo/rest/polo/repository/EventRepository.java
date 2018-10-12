package com.polo.rest.polo.repository;

import org.springframework.data.repository.CrudRepository;

import com.polo.rest.polo.entity.Event;

public interface EventRepository extends CrudRepository<Event, Integer>
{

    Event findById( Long eventId );
    
}
