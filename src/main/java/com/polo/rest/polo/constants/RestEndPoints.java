package com.polo.rest.polo.constants;

public interface RestEndPoints {

    String FILL_DATABASE = "/account/fill";
    String FILL_DATABASE_PERSONS = "/persons/fill";
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
	
    String GAME_CREATE = "/game/create";
    String GAME_GET = "/game/{eventId}";
    String GAME_GET_ALL = "/game/all";
    String GAME_DELETE_BY_ID = "/game/delete/{id}";
    String GAME_UPDATE = "/game/update";
    
    String TEAM_CREATE = "/team/create";
    String TEAM_GET = "/team/{teamName}";
    String TEAM_GET_ALL = "/team/all";
    String TEAM_DELETE_BY_ID = "/team/delete/{id}";
    String TEAM_UPDATE = "/team/update";
    
    
    
    
    
    
    
    
    
    
    
    /*
     EVENTS:

{"id":3, "name":"this is the body of the notification","picture":"niceeeee","priority":"hmmm","target":["level1", "level2"],"date":1188615600000,"content":"content", "location":"lisboa", "home":"porto", "away": "benfica", "homePlayers":[2, 3], "awayPlayers":[1, 4], "homeCoaches":[2], "awayCoaches":[3], "referees":["afonso"] }


GAME:

{"homeTeam":{"name":"e737324b-28f5-48ed-80da-b128f6230c8c", "logo":"Logo", "players":[null, null, null], "coaches":["coach dude"]}, 
	"awayTeam":{"name":"f95fd6d7-bb1c-4cf8-9763-2d429bec242d", "logo":"Logo", "players":[null, null, null], "coaches":["coach dude"]}, 
	"refereeList":["refOne", "refTwo"], "activity":null}


{"homeTeam":{"name":"Paredes", "logo":"Logo", "acronym": "PRD"}, 
	"awayTeam":{"name":"Porto", "logo":"Logo", "acronym": "PT"},
	"gameInformationJson":{
							"homeTeamPlayerList":[
												{"name":"player 1", "number": "4", "type":"PLAYER"}, 
												{"name":"player 2", "number": "2", "type":"PLAYER"}, 
												{"name":"player 3", "number": "8", "type":"PLAYER"}
											],
							"awayTeamPlayerList":[
												{"name":"player 4", "number": "3", "type":"PLAYER"}, 
												{"name":"player 5", "number": "1", "type":"PLAYER"}, 
												{"name":"player 6", "number": "7", "type":"PLAYER"}
											],
							"homeTeamCoacheList":[
												{"name":"Coach 1", "number": null, "type":"COACH"}, 
												{"name":"Coach 2", "number": null, "type":"COACH"}
											],
							"awayTeamCoacheList":[
												{"name":"Coach 3", "number": null, "type":"COACH"}, 
												{"name":"Coach 4", "number": null, "type":"COACH"}
											],
							"refereeList":[
												{"name":"Referee 1", "number": null, "type":"REFEREE"}, 
												{"name":"Referee 2", "number": null, "type":"REFEREE"}
											]
						},
	"activity":null}


TEAM

{"name":"e737324b-28f5-48ed-80da-b128f6230c8c", "logo":"Logo", "acronym":"PRD", "players":[{"name":"player 1", "number": "7", "type":"PLAYER"}, {"name":"player 2", "number": "5", "type":"PLAYER"}], "coaches":["coach dude"]}



private List<Person> homeTeamPlayerList;
    private List<Person> awayTeamPlayerList;
    private List<Person> homeTeamCoacheList;
    private List<Person> awayTeamCoacheList;
    private List<Person> refereeList;



 private String name;
    private String number;
    private String type;
     
     */
    
}
