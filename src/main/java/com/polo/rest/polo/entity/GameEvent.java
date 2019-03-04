package com.polo.rest.polo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GameEvent {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    private String lel;

    public long getId() {
        return id;
    }
    public void setId( long id ) {
        this.id = id;
    }
    public String getLel() {
        return lel;
    }
    public void setLel( String lel ) {
        this.lel = lel;
    }
    
    @Override
    public String toString() {
        return "GameEvent [id=" + id + ", lel=" + lel + "]";
    }
    
}
