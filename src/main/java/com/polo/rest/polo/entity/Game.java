package com.polo.rest.polo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Game {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

	@OneToOne(cascade=CascadeType.ALL)
	private Team homeTeam;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Team awayTeam;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Person> referee;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<GameEvent> activity;
	
	@ManyToMany(cascade=CascadeType.ALL)
    private List<Person> players;
    
    @ManyToMany(cascade=CascadeType.ALL)
    private List<Person> coaches;
	
    public long getId() {
        return id;
    }
    public void setId( long id ) {
        this.id = id;
    }
    public Team getHomeTeam() {
        return homeTeam;
    }
    public void setHomeTeam( Team homeTeam ) {
        this.homeTeam = homeTeam;
    }
    public Team getAwayTeam() {
        return awayTeam;
    }
    public void setAwayTeam( Team awayTeam ) {
        this.awayTeam = awayTeam;
    }
    public List<Person> getReferee() {
        return referee;
    }
    public void setReferee( List<Person> referee ) {
        this.referee = referee;
    }
    public List<GameEvent> getActivity() {
        return activity;
    }
    public void setActivity( List<GameEvent> activity ) {
        this.activity = activity;
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
    
    @Override
    public String toString() {
        return "Game [id=" + id + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", referee=" + referee + ", activity="
                + activity + ", players=" + players + ", coaches=" + coaches + "]";
    }
	
}
