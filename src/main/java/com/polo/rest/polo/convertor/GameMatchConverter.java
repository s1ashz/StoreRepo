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

    private static GameMatchConverter gameConvertorInstance = null;
    private GameMatchConverter() {}
    
    @Autowired
    private GameDao gameDao;
    
    @Autowired
    private TeamDao teamDao;
    
    @Autowired
    private PersonDao personDao;
    
    public Game convertGameDtoToGame( GameDto gameDto ) {
        
        Game gameEntity = new Game();
        
        return null;
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
        
        List<Person> playerEntityList = new ArrayList<>();
        for ( PersonDto personDto : teamDto.getPlayers() ) {
            try {
                System.out.println( personDto.toString() );
                System.out.println( personDao );
                playerEntityList.add( personDao.getPersonByNameAndNumber( personDto.getName(), personDto.getNumber() ) );
            } catch( PersonException e ) {
                e.printStackTrace();
            }
        }
        
        List<Person> coachesEntityList = new ArrayList<>();
        for ( String coachName : teamDto.getCoaches() ) {
            coachesEntityList.add( personDao.getPersonByNameAndType( coachName, COACH ) );
        }
        
        teamEntity.setPlayers( playerEntityList );
        teamEntity.setCoaches( coachesEntityList );
        
        return teamEntity;
    }
    
    
    
}
