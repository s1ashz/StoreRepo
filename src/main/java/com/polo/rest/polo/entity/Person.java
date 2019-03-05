package com.polo.rest.polo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "person_id")
    private long id;
    
    private String name;
    private String number;
    private String type;
    
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
    public String getNumber() {
        return number;
    }
    public void setNumber( String number ) {
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
        return "Persons [id=" + id + ", name=" + name + ", number=" + number + ", type=" + type + "]";
    }
    
}
