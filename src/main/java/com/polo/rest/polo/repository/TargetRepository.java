package com.polo.rest.polo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.polo.rest.polo.entity.Event;
import com.polo.rest.polo.entity.Target;

public interface TargetRepository extends CrudRepository<Target, Long>
{

    List<Target> findByEvent( Event eventEntity );
    List<Target> findByTarget( String target );

}
