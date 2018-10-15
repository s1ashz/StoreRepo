package com.polo.rest.polo.dto;

import java.util.Date;
import java.util.List;

public class AccountDto
{

    private int cardId;
    private String name;
    private String postalCode;
    private Date birthday;
    private String gender;
    private int mobileNumber;
    private List<ParentsDto> parents;
    private List<Integer> yearsPaid;
    private String level;
    private String size;
    private String observations;
    private String address;
    private boolean cc;
    private boolean exam;
    private boolean enrolled;
    private String email;
    private String token;
   
    public AccountDto() {
    }
    
    public int getCardId() {
        return cardId;
    }
    public void setCardId( int cardId ) {
        this.cardId = cardId;
    }
    public String getName() {
        return name;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode( String postalCode ) {
        this.postalCode = postalCode;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday( Date birthday ) {
        this.birthday = birthday;
    }
    public String getGender() {
        return gender;
    }
    public void setGender( String gender ) {
        this.gender = gender;
    }
    public int getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber( int mobileNumber ) {
        this.mobileNumber = mobileNumber;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel( String level ) {
        this.level = level;
    }
    public String getSize() {
        return size;
    }
    public void setSize( String size ) {
        this.size = size;
    }
    public String getObservations() {
        return observations;
    }
    public void setObservations( String observations ) {
        this.observations = observations;
    }
    public boolean isCc() {
        return cc;
    }
    public void setCc( boolean cc ) {
        this.cc = cc;
    }
    public boolean isExam() {
        return exam;
    }
    public void setExam( boolean exam ) {
        this.exam = exam;
    }
    public boolean isEnrolled() {
        return enrolled;
    }
    public void setEnrolled( boolean enrolled ) {
        this.enrolled = enrolled;
    }
	public List<ParentsDto> getParents() {
		return parents;
	}
	public void setParents(List<ParentsDto> parentsDtoList) {
		this.parents = parentsDtoList;
	}
    public String getEmail() {
        return email;
    }
    public void setEmail( String email ) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress( String address ) {
        this.address = address;
    }
    public List<Integer> getYearsPaid() {
        return yearsPaid;
    }
    public void setYearsPaid( List<Integer> yearsPaid ) {
        this.yearsPaid = yearsPaid;
    }
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "AccountDto [cardId=" + cardId + ", name=" + name + ", postalCode=" + postalCode + ", birthday="
				+ birthday + ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", parents=" + parents
				+ ", yearsPaid=" + yearsPaid + ", level=" + level + ", size=" + size + ", observations=" + observations
				+ ", address=" + address + ", cc=" + cc + ", exam=" + exam + ", enrolled=" + enrolled + ", email="
				+ email + ", token=" + token + "]";
	}

}
