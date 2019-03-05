package com.polo.rest.polo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polo.rest.polo.constants.ConstantManager;
import com.polo.rest.polo.dto.TeamDto;
import com.polo.rest.polo.exceptions.TeamException;
import com.polo.rest.polo.responses.ResponseJson;
import com.polo.rest.polo.service.TeamService;

@RestController
public class TeamControllerImpl implements ConstantManager {

	@Autowired
	private TeamService teamService;
	
	@RequestMapping( TEAM_CREATE )
    public ResponseJson createTeam( @RequestBody( required=true ) TeamDto teamDto ) {
    	System.out.println( teamDto.toString() );
        return teamService.createTeam( teamDto );
    }
    
    @RequestMapping( TEAM_GET ) 
    public TeamDto getTeam( @PathVariable(value="teamName", required=true ) String teamName ) throws TeamException {
        return teamService.getTeamWithName( teamName );
    }
    
    @RequestMapping( TEAM_GET_ALL )
    public List<TeamDto> getAllTeam() {
        return teamService.getAllTeams();
    }
    
    @RequestMapping( TEAM_DELETE_BY_ID )
    public ResponseJson deleteTeam( @PathVariable(value="id", required=true ) int teamId ) {
        return teamService.deleteTeamById( teamId );
    }
    
    @RequestMapping( TEAM_UPDATE )
    public ResponseJson updateTeam( @RequestBody( required=true ) TeamDto teamDto ) {
        return teamService.updateTeam( teamDto );
    }
	
	
	
}
