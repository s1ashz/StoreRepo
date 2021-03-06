package com.polo.rest.polo.convertor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.polo.rest.polo.constants.ConstantManager;
import com.polo.rest.polo.dao.GameDao;
import com.polo.rest.polo.dao.PersonDao;
import com.polo.rest.polo.dao.TeamDao;
import com.polo.rest.polo.dto.GameDto;
import com.polo.rest.polo.dto.PersonDto;
import com.polo.rest.polo.dto.TeamDto;
import com.polo.rest.polo.entity.Game;
import com.polo.rest.polo.entity.Participants;
import com.polo.rest.polo.entity.Person;
import com.polo.rest.polo.entity.Team;
import com.polo.rest.polo.exceptions.PersonException;
import com.polo.rest.polo.util.GsonInstance;

@Component
public class GameMatchConverter implements ConstantManager {

    private GameMatchConverter() {}
    
    @Autowired
    private GameDao gameDao;
    
    @Autowired
    private PersonDao personDao;
    
    public Game convertGameDtoToGame( GameDto gameDto ) {
//        List<Person> refereeEntityList = new ArrayList<>();
//        for ( String refereeName : gameDto.getRefereeList() ) {
//            Person referee = personDao.getPersonRefereeByName( refereeName );
//            if ( null == referee ) {
//            	referee = creatNewRefereeWithName( refereeName );
//            }
//            refereeEntityList.add( referee );
//        }

    	Game gameEntity = new Game();
        Team homeTeamEntity = convertTeamDtoToTeam( gameDto.getHomeTeam() );
        Team awayTeamEntity = convertTeamDtoToTeam( gameDto.getAwayTeam() );

        Gson gson = GsonInstance.getGson();
        String gameInformationJson = gson.toJson( gameDto.getParticipants() );
        
        gameEntity.setId( gameDto.getId() );
        gameEntity.setDate( gameDto.getDate() );
        
        gameEntity.setActivity( gameDto.getActivity() );
        gameEntity.setHomeTeam( homeTeamEntity );
        gameEntity.setAwayTeam( awayTeamEntity );
        gameEntity.setParticipants( gameInformationJson );
        gameEntity.setCompetition( gameDto.getCompetition() );
        gameEntity.setRound( gameDto.getRound() );
        gameEntity.setTime( gameDto.getTime() );
        gameEntity.setLocal( gameDto.getLocal() );
        gameEntity.setTarget( gameDto.getTarget() );

        return gameEntity;
    }
    
    public GameDto convertGameEntityToGameDto( Game gameEntity ) {
        GameDto gameDto = new GameDto();
        TeamDto homeTeamDto = convertTeamEntityToTeamDto( gameEntity.getHomeTeam() );
        TeamDto awayTeamDto = convertTeamEntityToTeamDto( gameEntity.getAwayTeam() );
        
        Gson gson = GsonInstance.getGson();
        Participants gameInformationJson = gson.fromJson( gameEntity.getParticipants(), Participants.class );
        
        gameDto.setId( gameEntity.getId() );
        gameDto.setDate( gameEntity.getDate() );
        gameDto.setHomeTeam( homeTeamDto );
        gameDto.setAwayTeam( awayTeamDto );
        gameDto.setParticipants( gameInformationJson );
        gameDto.setActivity( gameEntity.getActivity() );
        gameDto.setCompetition( gameEntity.getCompetition() );
        gameDto.setRound( gameEntity.getRound() );
        gameDto.setTime( gameEntity.getTime() );
        gameDto.setLocal( gameEntity.getLocal() );
        gameDto.setTarget( gameEntity.getTarget() );
        
        return gameDto;
    }

	public Person convertPersonDtoToPerson( PersonDto personDto ) {
        Person personEntity = new Person();
        personEntity.setName( personDto.getName() );
        personEntity.setNumber( personDto.getNumber() );
        personEntity.setType( personDto.getType() );
        personEntity.setTeam( personDto.getTeam() );

        return personEntity;
    }
	
	public PersonDto convertPersonEntityToPersonDto( Person personEntity ) {
        PersonDto personDto = new PersonDto();
        personDto.setName( personEntity.getName() );
        personDto.setNumber( personEntity.getNumber() );
        personDto.setType( personEntity.getType() );
        personDto.setTeam( personEntity.getTeam() );

        return personDto;
    }
    
    public Team convertTeamDtoToTeam( TeamDto teamDto ) {
        Team teamEntity = new Team();
        teamEntity.setName( teamDto.getName() );
        teamEntity.setLogo( teamDto.getLogo() );
        teamEntity.setAcronym( teamDto.getAcronym() );
        
        //List<Person> playerEntityList = convertPlayerDtoToPlayerEntityList( teamDto.getPlayers() );
        //List<Person> coachesEntityList = convertCoachesNamesToCoachesEntityList( teamDto.getCoaches() );
        
        //teamEntity.setPlayers( playerEntityList );
        //teamEntity.setCoaches( coachesEntityList );
        
        return teamEntity;
    }

    private List<Person> convertCoachesNamesToCoachesEntityList( List<String> coaches ) {
        List<Person> coachesEntityList = new ArrayList<>();
        for ( String coachName : coaches ) {
        	Person coach = personDao.getPersonCoachesByName( coachName );
        	if ( null == coach ) {
        		coach = creatNewCoachWithName( coachName );
        	}
        	
            coachesEntityList.add( coach );
        }
        return coachesEntityList;
    }
    
	private List<Person> convertPlayerDtoToPlayerEntityList( List<PersonDto> players ) {
        List<Person> playerEntityList = new ArrayList<>();
        for ( PersonDto personDto : players ) {
            try {
            	if ( null != personDto ) {
            		playerEntityList.add( personDao.getPersonByNameAndNumber( personDto.getName(), personDto.getNumber() ) );
            	}
            } catch( PersonException e ) {
                e.printStackTrace();
            }
        }
        return playerEntityList;
    }

    private Person creatNewCoachWithName( String coachName ) {
    	Person coach = new Person();
		coach.setName( coachName );
		coach.setType( COACH );
		try {
			personDao.createPerson( coach );
		} catch ( PersonException e ) {
			e.printStackTrace();
		}
		return coach;
	}
    
    private Person creatNewRefereeWithName( String refereeName ) {
    	Person referee = new Person();
		referee.setName( refereeName );
		referee.setType( REFEREE );
		try {
			personDao.createPerson( referee );
		} catch ( PersonException e ) {
			e.printStackTrace();
		}
		return referee;
	}

	public TeamDto convertTeamEntityToTeamDto( Team teamEntity ) {
		
		TeamDto teamDto = new TeamDto();
		teamDto.setName( teamEntity.getName() );
		teamDto.setLogo( teamEntity.getLogo() );
		teamDto.setAcronym( teamEntity.getAcronym() );
		
		List<PersonDto> playerEntityList = new ArrayList<>();
		List<String> coachesEntityList = new ArrayList<>();
		//teamDto.setPlayers( playerEntityList );
		//teamDto.setCoaches( coachesEntityList );
		
		return teamDto;
	}
    
}
