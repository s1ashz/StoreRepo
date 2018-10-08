package com.polo.rest.polo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Parent
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
	@ManyToOne
    private Account account;
	
    private String name;
    private String email;
    private int mobileNumber;
    
    public Parent() {
    }
    
    public int getId() {
        return id;
    }
    public void setId( int id ) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail( String email ) {
        this.email = email;
    }
    public int getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber( int mobileNumber ) {
        this.mobileNumber = mobileNumber;
    }
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
    
}
