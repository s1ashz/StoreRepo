package com.polo.rest.polo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.polo.rest.polo.constants.ConstantManager;
import com.polo.rest.polo.entity.Game;
import com.polo.rest.polo.exceptions.GameException;
import com.polo.rest.polo.repository.GameRepository;

@Repository
public class GameDao implements ConstantManager {

    @Autowired
    private GameRepository gameRepository;
    
    public Long createGame( Game game) throws GameException {
    	System.out.println( game );
        Game gamePersisted = gameRepository.save( game );
        if ( 0 == gamePersisted.getId() ) throw new GameException( EXCEPTION_GAME_NOT_CREATED ); 
        return gamePersisted.getId();
    }
    
    public Game getGame( Long gameId ) throws GameException {
        Game game = gameRepository.findGameById( gameId );
        if ( null == game ) throw new GameException( EXCEPTION_GAME_NOT_EXISTS + gameId );
        return game;
    }

    public List<Game> getAllGames() {
        return (List<Game>) gameRepository.findAll();
    }

    public void deleteEventById( long id ) {
        gameRepository.deleteById( id );
    }
    
    public boolean checkGameExists( long id ) {
    	return gameRepository.existsById( id );
    }
    
    public List<Game> getNextGames( int numberOfGames ) {
    	return gameRepository.findTop5ByOrderByDateDesc( numberOfGames );
    }

    public void updateGame( Game game ) throws GameException {
        if ( checkGameDoesNotExist( game ) ) {
            throwGameException( EXCEPTION_GAME_NOT_EXISTS + game.getId() );
        }
        Game databaseGame = getGame( game.getId() );
        updateEntityGameData( databaseGame, game );
        Game gamePersisted = gameRepository.save( databaseGame );
        if ( null == gamePersisted ) throwGameException( EXCEPTION_GAME_NOT_UPDATED + game.getId() ); 
        gameRepository.save( game );
    }

	private boolean checkGameDoesNotExist( Game game ) {
		return !checkGameExists( game.getId() );
	}

    private void updateEntityGameData( Game databaseGame, Game game ) {
		databaseGame.setActivity( game.getActivity() );
		databaseGame.setAwayTeam( game.getAwayTeam() );
		databaseGame.setHomeTeam( game.getHomeTeam() );
		databaseGame.setCompetition( game.getCompetition() );
		databaseGame.setDate( game.getDate() );
		databaseGame.setParticipants( game.getParticipants() );
		databaseGame.setRound( game.getRound() );
		databaseGame.setTime( game.getTime() );
	}
    
    private void throwGameException( String message ) throws GameException {
    	throw new GameException( message );
    }
    
}
