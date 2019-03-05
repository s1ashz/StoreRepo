package com.polo.rest.polo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private String logo;
    private String acronym;
    
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "person_id")
    private List<Person> players;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private List<Person> coaches;

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
    public String getLogo() {
        return logo;
    }
    public void setLogo( String logo ) {
        this.logo = logo;
    }
    public List<Person> getPlayers() {
        return players;
    }
    public void setPlayers( List<Person> players ) {
        this.players = players;
    }
    public List<Person> getCoaches() {
        return coaches;
    }
    public void setCoaches( List<Person> coaches ) {
        this.coaches = coaches;
    }
    public String getAcronym() {
		return acronym;
	}
	public void setAcronym( String acronym ) {
		this.acronym = acronym;
	}
	
	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", logo=" + logo + ", acronym=" + acronym + ", players=" + players + ", coaches=" + coaches + "]";
	}
    
}
