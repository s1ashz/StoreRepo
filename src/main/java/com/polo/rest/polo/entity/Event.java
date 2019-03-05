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
    
//    private boolean isGame;
//    private String home;
//    private String away;
//    
//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<Person> homePlayers;
//    
//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<Person> awayPlayers;
//    
//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<Person> homeCoaches;
//    
//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<Person> awayCoaches;
//    
//    @ElementCollection
//    private List<Person> referees;
//    
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Game> activity;
    
    
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
	
	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", picture=" + picture + ", priority=" + priority + ", location=" + location + ", date=" + date + ", content=" + content + "]";
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