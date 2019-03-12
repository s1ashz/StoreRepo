package com.polo.rest.polo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polo.rest.polo.constants.ConstantManager;
import com.polo.rest.polo.convertor.GameMatchConverter;
import com.polo.rest.polo.dao.GameDao;
import com.polo.rest.polo.dao.PersonDao;
import com.polo.rest.polo.dto.EventDto;
import com.polo.rest.polo.dto.GameDto;
import com.polo.rest.polo.dto.PersonDto;
import com.polo.rest.polo.dto.TeamDto;
import com.polo.rest.polo.entity.Game;
import com.polo.rest.polo.entity.GameEvent;
import com.polo.rest.polo.entity.Person;
import com.polo.rest.polo.entity.Team;
import com.polo.rest.polo.exceptions.AccountException;
import com.polo.rest.polo.exceptions.EventException;
import com.polo.rest.polo.exceptions.GameException;
import com.polo.rest.polo.exceptions.PersonException;
import com.polo.rest.polo.responses.ResponseJson;
import com.polo.rest.polo.service.GameService;

@RestController
public class GameControllerImpl implements ConstantManager {

	private static final Logger LOGGER = LoggerFactory.getLogger( GameControllerImpl.class );
	
    @Autowired
    private GameService gameService;
    
    @Autowired
    private PersonDao personDao;
    
    @Autowired
    private GameDao gameDao;
    
    @Autowired
    private GameMatchConverter gameMatchConverter;
    
    @RequestMapping( GAME_CREATE )
    public ResponseJson createGame( @RequestBody( required=true ) GameDto gameDto ) {
        return gameService.createGame( gameDto );
    }
    
    @RequestMapping( GAME_GET ) 
    public GameDto getGame( @PathVariable(value="gameId", required=true ) Long gameId ) throws GameException {
        return gameService.getGame( gameId );
    }
    
    @RequestMapping( GAME_GET_NEXT_GAMES )
    public List<GameDto> getNextGames( @PathVariable( value="numberOfGames", required=true) int numberOfGames ) {
        return gameService.getNextGames( numberOfGames );
    }
    
    @RequestMapping( GAME_GET_ALL )
    public List<GameDto> getAllGames() {
        return gameService.getAllGames();
    }
    
    @RequestMapping( GAME_DELETE_BY_ID )
    public ResponseJson deleteGame( @PathVariable(value="id", required=true ) int gameId ) throws EventException {
        return gameService.deleteGameById( gameId );
    }
    
    @RequestMapping( GAME_UPDATE )
    public ResponseJson updateGame( @RequestBody( required=true ) GameDto gameDto ) throws EventException {
        return gameService.updateGame( gameDto );
    }
    
    
    
    
    
    
    
    @RequestMapping("/persons/gameTest")
    public String testGameConvertor() throws AccountException, EventException {
        TeamDto homeTeamDto = createFastTeamDto();
        TeamDto awayTeamDto = createFastTeamDto();
        
        List<String> refereeList = new ArrayList<>();
        refereeList.add( "refOne" );
        refereeList.add( "refTwo" );
        
    	GameDto gameDto = createGameDto( homeTeamDto, awayTeamDto, refereeList );
    	
    	Game game = gameMatchConverter.convertGameDtoToGame( gameDto );
    	
    	try {
			gameDao.createGame( game );
		} catch ( GameException e ) {
			e.printStackTrace();
		}
    	
    	return game.toString();
    }
    
    
    
    private TeamDto createFastTeamDto() {
    	PersonDto person1 = createPersonDto( "player", "1", PLAYER );
        PersonDto person2 = createPersonDto( "player", "2", PLAYER );
        PersonDto person3 = createPersonDto( "player", "3", PLAYER );

        /*List<PersonDto> playerList = new ArrayList<>();
        playerList.add( person1 );
        playerList.add( person2 );
        playerList.add( person3 );
        List<String> coachList = new ArrayList<>();
        coachList.add( "coach dude" );
        */
        
        TeamDto teamDto = createTeamDto( UUID.randomUUID().toString(), "Logo"/*, playerList, coachList*/ );
        
		return teamDto;
	}

	private GameDto createGameDto( TeamDto homeTeam, TeamDto awayTeam, List<String> refereeList ) {
    	GameDto gameDto = new GameDto();
    	gameDto.setHomeTeam( homeTeam );
    	gameDto.setAwayTeam( awayTeam );
    	//gameDto.setRefereeList( refereeList );
    	
    	//home player list
    	//away player list
    	
    	
    	
    	List<GameEvent> gameEventList = new ArrayList<>();
    	gameDto.setActivity( gameEventList );
    	
		return gameDto;
	}

	@RequestMapping("/persons/teamTest")
    public String testTeamConvertor() throws AccountException, EventException {
        
        
        PersonDto person1 = createPersonDto( "player", "1", PLAYER );
        PersonDto person2 = createPersonDto( "player", "2", PLAYER );
        
        List<PersonDto> playerList = new ArrayList<>();
        playerList.add( person1 );
        playerList.add( person2 );
        
        List<String> coachList = new ArrayList<>();
        coachList.add( "coach dude" );
        
        TeamDto teamDto = createTeamDto( "Team1", "Logo"/*playerList, coachList*/ );
        
        Team team = gameMatchConverter.convertTeamDtoToTeam( teamDto );
        
        System.out.println( "***********************" );
        System.out.println( team.toString() );
    
        return teamDto.toString();
    }
    
    private TeamDto createTeamDto( String name, String logo/* List<PersonDto> playerList, List<String> coachList */ ) {
    	TeamDto teamDto = new TeamDto();
    	teamDto.setName( name );
    	teamDto.setLogo( logo );
    	//teamDto.setPlayers( playerList );
    	//teamDto.setCoaches( coachList );
    	
    	return teamDto;
    }
    
    private PersonDto createPersonDto(String name, String number, String type ) {
    	PersonDto person = new PersonDto();
    	person.setName( name + " " + number );
    	if ( PLAYER == type ) {
    		person.setNumber( number );
    	}
    	person.setType( type ); 
    	
    	return person;
    }
    
    
    @RequestMapping(FILL_DATABASE_PERSONS)
    public String createPersons() throws AccountException, EventException {
        
        Person person1 = new Person();
        person1.setName( "player 1" );
        person1.setNumber( "1" );
        person1.setType( PLAYER );
        
        Person person2 = new Person();
        person2.setName( "player 2" );
        person2.setNumber( "2" );
        person2.setType( PLAYER );
        
        Person coach = new Person();
        coach.setName( "coach dude" );
        coach.setNumber( null );
        coach.setType( COACH );
        
        try {
            personDao.createPerson( person1 );
            personDao.createPerson( person2 );
            personDao.createPerson( coach );
        } catch( PersonException e ) {
            e.printStackTrace();
        }
        
        
        try {
            Person dbPerson = personDao.getPersonByNameAndNumber( person1.getName(), person1.getNumber() );
            System.out.println( dbPerson.toString() );
            
            Person dbPerson2 = personDao.getPersonCoachesByName( coach.getName() );
            System.out.println( dbPerson2.toString() );
            
        } catch( PersonException e ) {
            e.printStackTrace();
        }
        
        
        
        
        return personDao.getAllPersons().toString();
    }
    
    
    
    
    
    
    
    
    
}
