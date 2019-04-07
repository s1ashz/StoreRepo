package com.polo.rest.polo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	
	@Column(columnDefinition = "TEXT")
	private String participants;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<GameEvent> activity;
//	@ManyToMany(cascade=CascadeType.ALL)
//	private List<Person> referee;
//	
//	@ManyToMany(cascade=CascadeType.ALL)
//    private List<Person> players;
//    
//    @ManyToMany(cascade=CascadeType.ALL)
//    private List<Person> coaches;

	
	private Date date;
	private String competition;
	private int round;
	private long time;
	private String local;
	private String target;
	
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
	public String getParticipants() {
		return participants;
	}
	public void setParticipants( String participants ) {
		this.participants = participants;
	}
	public List<GameEvent> getActivity() {
		return activity;
	}
	public void setActivity( List<GameEvent> activity ) {
		this.activity = activity;
	}
	public Date getDate() {
		return date;
	}
	public void setDate( Date date ) {
		this.date = date;
	}
	public String getCompetition() {
		return competition;
	}
	public void setCompetition( String competition ) {
		this.competition = competition;
	}
	public int getRound() {
		return round;
	}
	public void setRound( int round ) {
		this.round = round;
	}
	public long getTime() {
		return time;
	}
	public void setTime( long time ) {
		this.time = time;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal( String local ) {
		this.local = local;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget( String target ) {
		this.target = target;
	}
	
	@Override
	public String toString() {
		return "Game [id=" + id + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", participants=" + participants + ", activity=" + activity + ", date=" + date + ", competition=" + competition + ", round=" + round + ", time=" + time
				+ ", local=" + local + ", target=" + target + "]";
	}
	
}
