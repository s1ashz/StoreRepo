package com.polo.rest.polo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Event
{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    @Column(columnDefinition="TEXT")
    private String name;
    private String picture;
    private String priority;
    private String location;
    private Date date;
    @Column(columnDefinition="TEXT")
    private String content;
    
    private boolean isGame;
    private String home;
    private String away;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Account> homePlayers;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Account> awayPlayers;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Account> homeCoaches;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Account> awayCoaches;
    
    @ElementCollection
    private List<String> referees;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<GameEvent> activity;
    
    
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
	public String getPicture() {
		return picture;
	}
	public void setPicture( String picture ) {
		this.picture = picture;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority( String priority ) {
		this.priority = priority;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation( String location ) {
		this.location = location;
	}
	public Date getDate() {
		return date;
	}
	public void setDate( Date date ) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent( String content ) {
		this.content = content;
	}
	public boolean isGame() {
		return isGame;
	}
	public void setGame( boolean isGame ) {
		this.isGame = isGame;
	}
	public String getHome() {
		return home;
	}
	public void setHome( String home ) {
		this.home = home;
	}
	public String getAway() {
		return away;
	}
	public void setAway( String away ) {
		this.away = away;
	}
	public List<Account> getHomePlayers() {
		return homePlayers;
	}
	public void setHomePlayers( List<Account> homePlayers ) {
		this.homePlayers = homePlayers;
	}
	public List<Account> getAwayPlayers() {
		return awayPlayers;
	}
	public void setAwayPlayers( List<Account> awayPlayers ) {
		this.awayPlayers = awayPlayers;
	}
	public List<Account> getHomeCoaches() {
		return homeCoaches;
	}
	public void setHomeCoaches( List<Account> homeCoaches ) {
		this.homeCoaches = homeCoaches;
	}
	public List<Account> getAwayCoaches() {
		return awayCoaches;
	}
	public void setAwayCoaches( List<Account> awayCoaches ) {
		this.awayCoaches = awayCoaches;
	}
	public List<String> getReferees() {
		return referees;
	}
	public void setReferees( List<String> referees ) {
		this.referees = referees;
	}
	public List<GameEvent> getActivity() {
		return activity;
	}
	public void setActivity( List<GameEvent> activity ) {
		this.activity = activity;
	}
	
	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", picture=" + picture + ", priority=" + priority + ", location=" + location + ", date=" + date + ", content=" + content + ", isGame=" + isGame + ", home=" + home + ", away=" + away
				+ ", homePlayers=" + homePlayers + ", awayPlayers=" + awayPlayers + ", homeCoaches=" + homeCoaches + ", awayCoaches=" + awayCoaches + ", referees=" + referees + ", activity=" + activity + "]";
	}
    
    
    
    

}



/*
{
id
name,
pictureUrl,
priority,
target,
date,
content
}

*/