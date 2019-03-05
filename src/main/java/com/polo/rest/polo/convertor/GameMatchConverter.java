package com.polo.rest.polo.convertor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.polo.rest.polo.constants.ConstantManager;
import com.polo.rest.polo.dao.GameDao;
import com.polo.rest.polo.dao.PersonDao;
import com.polo.rest.polo.dao.TeamDao;
import com.polo.rest.polo.dto.GameDto;
import com.polo.rest.polo.dto.PersonDto;
import com.polo.rest.polo.dto.TeamDto;
import com.polo.rest.polo.entity.Game;
import com.polo.rest.polo.entity.Person;
import com.polo.rest.polo.entity.Team;
import com.polo.rest.polo.exceptions.PersonException;

@Component
public class GameMatchConverter implements ConstantManager {

    private GameMatchConverter() {}
    
    @Autowired
    private GameDao gameDao;
    
    @Autowired
    private TeamDao teamDao;
    
    @Autowired
    private PersonDao personDao;
    
    public Game convertGameDtoToGame( GameDto gameDto ) {
        Game gameEntity = new Game();

        Team homeTeamEntity = convertTeamDtoToTeam( gameDto.getHomeTeam() );
        Team awayTeamEntity = convertTeamDtoToTeam( gameDto.getAwayTeam() );
        
        List<Person> refereeEntityList = new ArrayList<>();
        for ( String refereeName : gameDto.getRefereeList() ) {
            //TODO if referee doesnt exist create him
            Person referee = personDao.getPersonRefereeByName( refereeName );
            refereeEntityList.add( referee );
        }
        
        gameEntity.setActivity( null );
        gameEntity.setHomeTeam( homeTeamEntity );
        gameEntity.setAwayTeam( awayTeamEntity );
        gameEntity.setReferee( refereeEntityList );

        return gameEntity;
    }
    
    public Person convertPersonDtoToPerson( PersonDto personDto ) {
        Person personEntity = new Person();
        personEntity.setName( personDto.getName() );
        personEntity.setNumber( personDto.getNumber() );
        personEntity.setType( personDto.getType() );

        return personEntity;
    }
    
    public Team convertTeamDtoToTeam( TeamDto teamDto ) {
        Team teamEntity = new Team();
        teamEntity.setName( teamDto.getName() );
        teamEntity.setLogo( teamDto.getLogo() );
        
        List<Person> playerEntityList = convertPlayerDtoToPlayerEntityList( teamDto.getPlayers() );
        List<Person> coachesEntityList = convertCoachesNamesToCoachesEntityList( teamDto.getCoaches() );
        
        teamEntity.setPlayers( playerEntityList );
        teamEntity.setCoaches( coachesEntityList );
        
        return teamEntity;
    }

    private List<Person> convertCoachesNamesToCoachesEntityList( List<String> coaches ) {
        List<Person> coachesEntityList = new ArrayList<>();
        for ( String coachName : coaches ) {
            //TODO if referee doesnt exist create him
            coachesEntityList.add( personDao.getPersonCoachesByName( coachName ) );
        }
        return coachesEntityList;
    }

    private List<Person> convertPlayerDtoToPlayerEntityList( List<PersonDto> players ) {
        List<Person> playerEntityList = new ArrayList<>();
        for ( PersonDto personDto : players ) {
            try {
                playerEntityList.add( personDao.getPersonByNameAndNumber( personDto.getName(), personDto.getNumber() ) );
            } catch( PersonException e ) {
                e.printStackTrace();
            }
        }
        return playerEntityList;
    }
    
    
}
