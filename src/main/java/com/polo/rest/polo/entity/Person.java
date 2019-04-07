package com.polo.rest.polo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="person")
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    private String name;
    private int number;
    private String type;
    private String team;
    
    public String getTeam() {
		return team;
	}
	public void setTeam( String team ) {
		this.team = team;
	}
	public long getId() {
        return id;
    }
    public void setId( long id ) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber( int number ) {
        this.number = number;
    }
    public String getType() {
        return type;
    }
    public void setType( String type ) {
        this.type = type;
    }
    
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", number=" + number + ", type=" + type + ", team=" + team + "]";
	}
    
}
