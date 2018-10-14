package com.polo.rest.polo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.polo.rest.polo.entity.Event;

public interface EventRepository extends CrudRepository<Event, Long>
{

    Optional<Event> findById( Long eventId );
    List<Event> getByTarget( String target );
    
}
