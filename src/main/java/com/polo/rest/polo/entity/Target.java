package com.polo.rest.polo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Target
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String target;
    
    @ManyToOne
    private Event event;

    public Long getId() {
        return id;
    }
    public void setId( Long id ) {
        this.id = id;
    }
    public String getTarget() {
        return target;
    }
    public void setTarget( String target ) {
        this.target = target;
    }
    public Event getEvent() {
        return event;
    }
    public void setEvent( Event event ) {
        this.event = event;
    }
    
    @Override
    public String toString() {
        return "Target [id=" + id + ", target=" + target + ", event=" + event + "]";
    }
    
}
