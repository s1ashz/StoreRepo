package com.polo.rest.polo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polo.rest.polo.constants.ConstantManager;
import com.polo.rest.polo.convertor.GameMatchConverter;
import com.polo.rest.polo.dao.TeamDao;
import com.polo.rest.polo.dto.TeamDto;
import com.polo.rest.polo.entity.Team;
import com.polo.rest.polo.exceptions.TeamException;
import com.polo.rest.polo.responses.ResponseJson;
import com.polo.rest.polo.validators.TeamValidator;

@Service
public class TeamService implements ConstantManager {

	@Autowired
	private TeamDao teamDao;
	
	@Autowired
	private TeamValidator teamValidator;
	
	@Autowired
	private GameMatchConverter gameMatchConverter;
	
    public ResponseJson createTeam( TeamDto teamDto ) {
        teamValidator.validateGame( teamDto );
        
        Team team = gameMatchConverter.convertTeamDtoToTeam( teamDto );
        
    	try {
			teamDao.createTeam( team );
		} catch ( TeamException e ) {
			e.printStackTrace();
		}

    	return null;
    }

    public TeamDto getTeamWithName( String teamName ) throws TeamException {
    	Team teamEntity = teamDao.getTeamByName( teamName );
    	if ( null == teamEntity ) {
    		throw new TeamException( EXCEPTION_TEAM_NOT_EXISTS );
    	}
    	TeamDto teamDto = gameMatchConverter.convertTeamEntityToTeamDto( teamEntity );
    	
    	return teamDto;
    }

    public List<TeamDto> getAllTeams() {
        // TODO Auto-generated method stub
        return null;
    }

    public ResponseJson deleteTeamById( int teamId ) {
        // TODO Auto-generated method stub
        return null;
    }

    public ResponseJson updateTeam( TeamDto teamDto ) {
        // TODO Auto-generated method stub
        return null;
    }
	
	
	
	
	
}
