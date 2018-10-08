package com.polo.rest.polo.constants;

public interface RestEndPoints {

    String FILL_DATABASE = "/account/fill";
	String ACCOUNT_VALIDATOR = "/account/validate";
	String ACCOUNT_CREATE = "/account/create";
	String ACCOUNT_GET_ACCOUNT_BY_CARD_ID = "/account/get/{cardId}";
	String ACCOUNT_GET_ALL_ACCOUNTS = "/account/all";
	String ACCOUNT_UPDATE = "/account/update/{cardId}";
	String ACCOUNT_DELETE_ALL_DATABASE = "/account/delete/all";
	
	
	String PAYMENTS_CREATE = "/account/payments/pay/{cardId}/{year}/{month}";
	String PAYMENTS_GET_BY_CARD_ID = "/account/payments/{cardId}/{year}";
	
}
