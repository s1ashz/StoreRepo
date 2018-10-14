package com.polo.rest.polo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event
{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private String picture;
    private String priority;
    private String location;
    private String target;
    private Date date;
    private String content;
    
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
    public String getTarget() {
        return target;
    }
    public void setTarget( String target ) {
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
    public String getLocation() {
        return location;
    }
    public void setLocation( String location ) {
        this.location = location;
    }
    
    @Override
    public String toString() {
        return "Event [id=" + id + ", name=" + name + ", picture=" + picture + ", priority=" + priority + ", location=" + location
                + ", target=" + target + ", date=" + date + ", content=" + content + "]";
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