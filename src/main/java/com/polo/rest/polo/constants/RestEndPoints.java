package com.polo.rest.polo.constants;

public interface RestEndPoints {

    String FILL_DATABASE = "/account/fill";
	String ACCOUNT_AUTHENTICATE = "/account/authenticate";
	String ACCOUNT_LOGOUT = "/account/logout";
	String ACCOUNT_CREATE = "/account/create";
	String ACCOUNT_GET_ACCOUNT_BY_CARD_ID = "/account/{cardId}";
	String ACCOUNT_GET_ALL_ACCOUNTS = "/account/all";
	String ACCOUNT_UPDATE = "/account/update";
	String ACCOUNT_DELETE = "/account/delete/{cardId}";
	String ACCOUNT_DELETE_ALL_DATABASE = "/account/delete/all";
	String EVENT_GET_ALL_BY_CARD_ID= "/account/{cardId}/events";
	
	String PAYMENTS_CREATE = "/payments/create";
	String PAYMENTS_GET_BY_CARD_ID_AND_YEAR = "/account/payments/{cardId}/{year}";
	
	String EVENT_CREATE = "/event/create";
    String EVENT_GET = "/event/{eventId}";
    String EVENT_GET_ALL = "/event/all";
    String EVENT_DELETE_BY_ID = "/event/delete/{id}";
    String EVENT_UPDATE = "/event/update";
	
}
