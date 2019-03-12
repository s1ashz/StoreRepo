package com.polo.rest.polo.constants;

public interface ExceptionMessages {

	String EXCEPTION_ACCOUNT_ALREAD_EXISTS = "Account already exists with the Card Id: ";
	String EXCEPTION_ACCOUNT_NOT_EXISTS = "Account does not exist with the Card Id: ";
	String EXCEPTION_INVALID_ACCOUNT_MESSAGE = "Invalid Account Field: ";
	String EXCEPTION_INVALID_PARENT_MESSAGE = "Invalid Parent Field: ";
	String EXCEPTION_PARENT_NULL = "Parent Null: ";
	
	String EXCEPTION_EVENT_NOT_CREATED = "The event was not created. Name: ";
	String EXCEPTION_EVENT_TARGET_NULL = "Target cannot be null: ";
	String EXCEPTION_INVALID_EVENT_MESSAGE = "Invalid Event Field: ";
	String EXCEPTION_EVENT_NOT_EXISTS = "Event does not exist with the id: ";

	String EXCEPTION_INVALID_LOGIN = "Invalid Login: ";
	String EXCEPTION_INVALID_EMAIL = "Invalid Email entered: ";
	String EXCEPTION_INVALID_CARD_ID = "Invalid Card Id entered: ";
	
	String EXCEPTION_EMAIL_NOT_EXISTS = "The inserted email does not exist: ";

	String EXCEPTION_PAYMENT_NOT_EXISTS = "Payment does not exist with the Card Id and Year: ";
	
	String EXCEPTION_GAME_NOT_CREATED = "The game was not created.";
    String EXCEPTION_GAME_NOT_EXISTS = "Game does not exist with the id: ";
    String EXCEPTION_GAME_NULL = "Game cannot be null";
    String EXCEPTION_UPDATED_GAME_ID_NULL = "Updated Game id cannot be null";
    
    String EXCEPTION_TEAM_NOT_CREATED = "The Team was not created.";
    String EXCEPTION_TEAM_NOT_EXISTS = "Team does not exist with the name: ";
    String EXCEPTION_TEAM_ALREADY_EXISTS = "Team already exists with the name: ";
    
    String EXCEPTION_PERSON_NOT_CREATED = "The person was not created: Name: ";
    String EXCEPTION_PERSON_NOT_EXISTS = "Person does not exist with the id: ";
	
}
