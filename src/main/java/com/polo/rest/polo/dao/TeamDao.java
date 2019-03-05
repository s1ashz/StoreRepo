package com.polo.rest.polo.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.polo.rest.polo.constants.ConstantManager;
import com.polo.rest.polo.entity.Team;
import com.polo.rest.polo.exceptions.TeamException;
import com.polo.rest.polo.repository.TeamRepository;

@Repository
public class TeamDao implements ConstantManager {
	
	@Autowired
	private TeamRepository teamRepository;
	
	public Long createTeam( Team team) throws TeamException {
		if ( checkteamExistsWithName( team.getName() ) ) {
			throw new TeamException( EXCEPTION_TEAM_NOT_CREATED + team.getName() );
		}
		Team teamPersisted = teamRepository.save( team );
	    if ( 0 == teamPersisted.getId() ) throw new TeamException( EXCEPTION_TEAM_NOT_CREATED + team.getName() ); 
	    return teamPersisted.getId();
	}
	
	public Team getTeam( Long eventId ) throws TeamException {
	    Optional<Team> teamOp = null;
	    if (!teamOp.isPresent() ) throw new TeamException( EXCEPTION_TEAM_NOT_EXISTS );
	    return teamOp.get();
	}
	
	public List<Team> getAllTeams() {
	    return (List<Team>) teamRepository.findAll();
	}
	
	public void deleteTeamById( long id ) {
	    teamRepository.deleteById( id );
	}
	
	public void updateTeam( Team event ) {
	    teamRepository.save( event );
	}
	
	public boolean checkteamExistsWithName( String teamName ) {
	    return teamRepository.existsByName( teamName );
	}

	public Team getTeamByName( String teamName ) {
		return teamRepository.findAllByName( teamName );
	}

}
