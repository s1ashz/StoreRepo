package com.polo.rest.polo.responses;

public class AuthenticationJson
{

    private int cardId;
    private String email;
    private String firebaseToken;
    
    public int getCardId() {
        return cardId;
    }
    public void setCardId( int cardId ) {
        this.cardId = cardId;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail( String email ) {
        this.email = email;
    }
    public String getFirebaseToken() {
        return firebaseToken;
    }
    public void setFirebaseToken( String firebaseToken ) {
        this.firebaseToken = firebaseToken;
    }
    
}
