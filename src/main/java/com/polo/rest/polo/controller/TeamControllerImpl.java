package com.polo.rest.polo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polo.rest.polo.constants.ConstantManager;
import com.polo.rest.polo.dao.TeamDao;
import com.polo.rest.polo.dto.EventDto;
import com.polo.rest.polo.dto.GameDto;
import com.polo.rest.polo.exceptions.EventException;
import com.polo.rest.polo.responses.ResponseJson;

@RestController
public class TeamControllerImpl implements ConstantManager {

	@Autowired
	private TeamService teamService;
	
	@RequestMapping( TEAM_CREATE )
    public ResponseJson createGame( @RequestBody( required=true ) GameDto gameDto ) throws EventException {
    	System.out.println( gameDto.toString() );
        return teamDao.createGame( gameDto );
    }
    
    @RequestMapping( TEAM_GET ) 
    public EventDto getGame( @PathVariable(value="eventId", required=true ) Long gameId ) throws EventException {
        return teamDao.getGame( gameId );
    }
    
    @RequestMapping( TEAM_GET_ALL )
    public List<EventDto> getAllEvents() {
        return teamDao.getAllGames();
    }
    
    @RequestMapping( TEAM_DELETE_BY_ID )
    public ResponseJson deleteGame( @PathVariable(value="id", required=true ) int gameId ) throws EventException {
        return teamDao.deleteGameById( gameId );
    }
    
    @RequestMapping( TEAM_UPDATE )
    public ResponseJson updateGame( @RequestBody( required=true ) GameDto eventDto ) throws EventException {
        return teamDao.updateGame( eventDto );
    }
	
	
	
}
