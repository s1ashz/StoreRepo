package com.polo.rest.polo.responses;

public class AuthenticationJson
{

    private int cardId;
    private String email;
    private String token;
    
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "AuthenticationJson [cardId=" + cardId + ", email=" + email + ", token=" + token + "]";
	}
    
}
