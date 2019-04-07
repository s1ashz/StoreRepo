package com.polo.rest.polo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.polo.rest.polo.constants.ConstantManager;
import com.polo.rest.polo.entity.GameEvent;
import com.polo.rest.polo.exceptions.GameEventException;
import com.polo.rest.polo.repository.GameEventRepository;

public class GameEventDao implements ConstantManager {

	@Autowired
	private GameEventRepository gameEventRepository;
	
	public Long createGameEvent( GameEvent gameEvent ) throws GameEventException {
    	System.out.println( gameEvent );
    	GameEvent gameEventPersisted = gameEventRepository.save( gameEvent );
        if ( 0 == gameEventPersisted.getId() ) throwGameEventException( EXCEPTION_GAME_EVENT_NOT_CREATED ); 
        return gameEventPersisted.getId();
    }
    
    public GameEvent getGameEvent( Integer gameEventId ) throws GameEventException {
        GameEvent gameEvent = gameEventRepository.findGameEventById( gameEventId );
        if ( null == gameEvent ) throwGameEventException( EXCEPTION_GAME_EVENT_NOT_EXISTS + gameEventId );
        return gameEvent;
    }

    public List<GameEvent> getAllGames() {
        return (List<GameEvent>) gameEventRepository.findAll();
    }

    public void deleteGameEventById( long id ) {
        gameEventRepository.deleteById( id );
    }
    
    public boolean checkGameEventExists( long id ) {
    	return gameEventRepository.existsById( id );
    }

    public void updateGame( GameEvent gameEvent ) throws GameEventException {
        if ( checkGameEventDoesNotExist( gameEvent ) ) {
            throwGameEventException( EXCEPTION_GAME_EVENT_NOT_EXISTS + gameEvent.getId() );
        }
        GameEvent databaseGameEvent = gameEventRepository.findGameEventById( gameEvent.getId() );
        updateEntityGameEventData( databaseGameEvent, gameEvent );
        GameEvent gameEventPersisted = gameEventRepository.save( databaseGameEvent );
        if ( null == gameEventPersisted ) throwGameEventException( EXCEPTION_GAME_NOT_UPDATED + gameEvent.getId() ); 
        gameEventRepository.save( gameEvent );
    }

	private boolean checkGameEventDoesNotExist( GameEvent game ) {
		return !checkGameEventExists( game.getId() );
	}

    private void updateEntityGameEventData( GameEvent databaseGameEvent, GameEvent gameEvent ) {
		databaseGameEvent.setGameEventType( gameEvent.getGameEventType() );
		databaseGameEvent.setPeriod( gameEvent.getPeriod() );
		databaseGameEvent.setPlayerName( gameEvent.getPlayerName() );
		databaseGameEvent.setTeam( gameEvent.getTeam() );
		databaseGameEvent.setTime( gameEvent.getTime() );
	}
    
    private void throwGameEventException( String message ) throws GameEventException {
    	throw new GameEventException( message );
    }
	
	
}
