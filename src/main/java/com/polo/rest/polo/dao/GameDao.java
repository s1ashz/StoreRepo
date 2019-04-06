package com.polo.rest.polo.dao;

import static com.polo.rest.polo.constants.ExceptionMessages.EXCEPTION_GAME_NOT_CREATED;
import static com.polo.rest.polo.constants.ExceptionMessages.EXCEPTION_GAME_NOT_EXISTS;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.polo.rest.polo.constants.ConstantManager;
import com.polo.rest.polo.entity.Game;
import com.polo.rest.polo.entity.Team;
import com.polo.rest.polo.exceptions.GameException;
import com.polo.rest.polo.exceptions.TeamException;
import com.polo.rest.polo.repository.GameRepository;
import com.polo.rest.polo.repository.TeamRepository;

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

    public void updateGame( Game game ) throws GameException {
        if ( !checkGameExists( game.getId() ) ) {
            throwGameException( EXCEPTION_GAME_NOT_EXISTS + game.getId() );
        }
        Game databaseGame = getGame( game.getId() );
        updateEntityGameData( databaseGame, game );
        Game gamePersisted = gameRepository.save( databaseGame );
        if ( null == gamePersisted ) throwGameException( EXCEPTION_TEAM_NOT_UPDATED + game.getId() ); 
        gameRepository.save( game );
    }

    private void updateEntityGameData( Game databaseGame, Game game ) {
		databaseGame.setActivity( game.getActivity() );
		databaseGame.setAwayTeam( game.getAwayTeam() );
		databaseGame.setHomeTeam( game.getHomeTeam() );
		databaseGame.setCompetition( game.getCompetition() );
		databaseGame.setDate( game.getDate() );
		databaseGame.setGameInformationJson( game.getGameInformationJson() );
		databaseGame.setRound( game.getRound() );
		databaseGame.setTime( game.getTime() );
	}

	public boolean checkGameExists( long id ) {
        return gameRepository.existsById( id );
    }

    public List<Game> getNextGames( int numberOfGames ) {
        return gameRepository.findTop5ByOrderByDateDesc( numberOfGames );
    }
    
    private void throwGameException( String message ) throws GameException {
    	throw new GameException( message );
    }
    
}
