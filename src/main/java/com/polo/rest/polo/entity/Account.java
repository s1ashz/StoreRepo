package com.polo.rest.polo.entity;

public class Account
{

    private int id;
    private int cardId;
    private String name;
    private String postalCode;
    private String birthday;
    private String gender;
    private int mobileNumber;
    private Parents parents;
    private String level;
    private String size;
    private String observations;
    private boolean cc;
    private boolean exam;
    private boolean enrolled;
   
    public Account() {
    }
    
    public int getId() {
        return id;
    }
    public void setId( int id ) {
        this.id = id;
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
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday( String birthday ) {
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
    public Parents getParents() {
        return parents;
    }
    public void setParents( Parents parents ) {
        this.parents = parents;
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
    
    @Override
    public String toString() {
        return "Account [id=" + id + ", cardId=" + cardId + ", name=" + name + ", postalCode=" + postalCode + ", birthday="
                + birthday + ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", parents=" + parents + ", level=" + level
                + ", size=" + size + ", observations=" + observations + ", cc=" + cc + ", exam=" + exam + ", enrolled=" + enrolled
                + "]";
    }
    
}
