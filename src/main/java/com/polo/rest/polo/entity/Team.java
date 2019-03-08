package com.polo.rest.polo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="team")
public class Team {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private String logo;
    private String acronym;
    
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
    public String getAcronym() {
		return acronym;
	}
	public void setAcronym( String acronym ) {
		this.acronym = acronym;
	}
	
    @Override
    public String toString() {
        return "Team [id=" + id + ", name=" + name + ", logo=" + logo + ", acronym=" + acronym + "]";
    }

}
