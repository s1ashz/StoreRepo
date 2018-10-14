package com.polo.rest.polo.constants;

public interface ExceptionMessages {

	String EXCEPTION_ACCOUNT_ALREAD_EXISTS = "Account already exists with the cardId: ";
	String EXCEPTION_ACCOUNT_NOT_EXISTS = "Account does not exist with the cardId: ";
	String EXCEPTION_INVALID_ACCOUNT_MESSAGE = "Invalid Account Field: ";
	String EXCEPTION_INVALID_PARENT_MESSAGE = "Invalid Parent Field: ";
	String EXCEPTION_PARENT_NULL = "Parent Null: ";
	
	String EXCEPTION_PAYMENT_NOT_EXISTS = "Payment does not exist with the cardId and Year: ";
	
	String EXCEPTION_EVENT_NOT_EXISTS = "Event does not exist with the id: ";
	
	
}
