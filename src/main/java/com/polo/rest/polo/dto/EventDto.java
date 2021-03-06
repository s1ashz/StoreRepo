package com.polo.rest.polo.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.polo.rest.polo.entity.Account;

public class EventDto
{

    private long id;
    private String name;
    private String picture;
    private String priority;
    private String location;
    private List<String> target;
    private Date date;
    private String content;
    private boolean publicEvent;
    
//    private boolean isGame;
//    private String home;
//    private String away;
//    private List<Integer> homePlayers;
//    private List<Integer> awayPlayers;
//    private List<Integer> homeCoaches;
//    private List<Integer> awayCoaches;
//    private List<String> referees;
    
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
	public List<String> getTarget() {
		return target;
	}
	public void setTarget( List<String> target ) {
		this.target = target;
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
    public boolean isPublicEvent() {
		return publicEvent;
	}
	public void setPublicEvent( boolean publicEvent ) {
		this.publicEvent = publicEvent;
	}
	@Override
    public String toString() {
        return "EventDto [id=" + id + ", name=" + name + ", picture=" + picture + ", priority=" + priority + ", location="
                + location + ", target=" + target + ", date=" + date + ", content=" + content + ", publicEvent=" + publicEvent
                + "]";
    }
    
}
