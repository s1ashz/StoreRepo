package com.polo.rest.polo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polo.rest.polo.constants.ConstantManager;
import com.polo.rest.polo.convertor.GameMatchConverter;
import com.polo.rest.polo.dao.PersonDao;
import com.polo.rest.polo.dto.EventDto;
import com.polo.rest.polo.dto.GameDto;
import com.polo.rest.polo.dto.PersonDto;
import com.polo.rest.polo.dto.TeamDto;
import com.polo.rest.polo.entity.Person;
import com.polo.rest.polo.entity.Team;
import com.polo.rest.polo.exceptions.AccountException;
import com.polo.rest.polo.exceptions.EventException;
import com.polo.rest.polo.exceptions.PersonException;
import com.polo.rest.polo.responses.ResponseJson;
import com.polo.rest.polo.service.GameService;

@RestController
public class GameControllerImpl implements ConstantManager {

    @Autowired
    private GameService gameService;
    
    @Autowired
    private PersonDao personDao;
    
    @Autowired
    private GameMatchConverter gameMatchConverter;
    
    
    
    
    @RequestMapping( GAME_CREATE )
    public ResponseJson createGame( @RequestBody( required=true ) GameDto gameDto ) throws EventException {
        return gameService.createGame( gameDto );
    }
    
    @RequestMapping( GAME_GET ) 
    public EventDto getGame( @PathVariable(value="eventId", required=true ) Long gameId ) throws EventException {
        return gameService.getGame( gameId );
    }
    
    @RequestMapping( GAME_GET_ALL )
    public List<EventDto> getAllEvents() {
        return gameService.getAllGames();
    }
    
    @RequestMapping( GAME_DELETE_BY_ID )
    public ResponseJson deleteGame( @PathVariable(value="id", required=true ) int gameId ) throws EventException {
        return gameService.deleteGameById( gameId );
    }
    
    @RequestMapping( GAME_UPDATE )
    public ResponseJson updateGame( @RequestBody( required=true ) GameDto eventDto ) throws EventException {
        return gameService.updateGame( eventDto );
    }
    
    
    
    
    
    
    
    
    
    @RequestMapping("/persons/test")
    public String testTeamConvertor() throws AccountException, EventException {
        
        TeamDto teamDto = new TeamDto();
        
        PersonDto person1 = new PersonDto();
        person1.setName( "player 1" );
        person1.setNumber( "1" );
        person1.setType( PLAYER );
        
        PersonDto person2 = new PersonDto();
        person2.setName( "Player 2" );
        person2.setNumber( "2" );
        person2.setType( PLAYER );
        
        PersonDto coach = new PersonDto();
        coach.setName( "coach dude" );
        coach.setNumber( null );
        coach.setType( COACH );
        
        List<PersonDto> playerList = new ArrayList<>();
        playerList.add( person1 );
        playerList.add( person2 );
        
        List<String> coachList = new ArrayList<>();
        coachList.add( "coach dude" );
        
        teamDto.setName( "Team1" );
        teamDto.setLogo( "Logo" );
        teamDto.setCoaches( coachList );
        teamDto.setPlayers( playerList );
        
        Team team = gameMatchConverter.convertTeamDtoToTeam( teamDto );
        
        System.out.println( "***********************" );
        System.out.println( team.toString() );
    
        return team.toString();
    }
    
    
    
    @RequestMapping(FILL_DATABASE_PERSONS)
    public String createPersons() throws AccountException, EventException {
        
        Person person1 = new Person();
        person1.setName( "player 1" );
        person1.setNumber( "1" );
        person1.setType( PLAYER );
        
        Person person2 = new Person();
        person2.setName( "Player 2" );
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
            
            Person dbPerson2 = personDao.getPersonByNameAndType( person1.getName(), person1.getType() );
            System.out.println( dbPerson2.toString() );
            
        } catch( PersonException e ) {
            e.printStackTrace();
        }
        
        
        
        
        return personDao.getAllPersons().toString();
    }
    
    
    
    
    
    
    
    
    
}
