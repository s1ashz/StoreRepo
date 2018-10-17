package com.polo.rest.polo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.polo.rest.polo.entity.Event;
import com.polo.rest.polo.entity.Target;
import com.polo.rest.polo.repository.TargetRepository;

@Repository
public class TargetDao
{

    @Autowired
    private TargetRepository targetRepository;
    
    public void createTarget( List<Target> targetEntityList ) {
        targetRepository.saveAll( targetEntityList );
    }

    public List<Target> findTargetByEvent( Event eventEntity ) {
        return targetRepository.findByEvent( eventEntity );
    }

    public void deleteTargetList( List<Target> targetEntityList ) {
        targetRepository.deleteAll( targetEntityList );
    }

    public List<Target> findByTarget( String target ) {
        return targetRepository.findByTarget( target );
    }
    
}
