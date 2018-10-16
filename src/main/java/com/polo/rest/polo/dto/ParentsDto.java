package com.polo.rest.polo.dto;

public class ParentsDto
{

    private String name;
    private String email;
    private int mobileNumber;
    
    public ParentsDto() {
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

    @Override
    public String toString() {
        return "ParentsDto [name=" + name + ", email=" + email + ", mobileNumber=" + mobileNumber + "]";
    }
    
}
