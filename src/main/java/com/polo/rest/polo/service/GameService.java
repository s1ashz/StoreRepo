package com.polo.rest.polo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.polo.rest.polo.constants.ConstantManager;
import com.polo.rest.polo.controller.GameControllerImpl;
import com.polo.rest.polo.convertor.GameMatchConverter;
import com.polo.rest.polo.dao.GameDao;
import com.polo.rest.polo.dao.TeamDao;
import com.polo.rest.polo.dto.EventDto;
import com.polo.rest.polo.dto.GameDto;
import com.polo.rest.polo.entity.Game;
import com.polo.rest.polo.entity.Team;
import com.polo.rest.polo.exceptions.GameException;
import com.polo.rest.polo.responses.ResponseJson;
import com.polo.rest.polo.validators.GameValidator;

@Service
@Transactional
public class GameService implements ConstantManager {

    @Autowired
    private GameDao gameDao;
    
    @Autowired
    private TeamDao teamDao;
    
    @Autowired
    private GameValidator gameValidator;
    
    @Autowired
    private GameMatchConverter gameMatchConverter;
    
    public ResponseJson createGame( GameDto gameDto ) {
        try {
            gameValidator.validateGame( gameDto );
            Game game = gameMatchConverter.convertGameDtoToGame( gameDto );
            gameDao.createGame( game );

            return new ResponseJson( CREATE, true, game.getId() );
        } catch( GameException e ) {
            e.printStackTrace();
        }
        return new ResponseJson( CREATE, false );
    }

    public GameDto getGame( Long gameId ) throws GameException {
        Game game = gameDao.getGame( gameId );
        GameDto gameDto = gameMatchConverter.convertGameEntityToGameDto( game );
        return gameDto;
    }
    
    public List<GameDto> getNextGames( int numberOfGames ) {
        List<Game> gameEntityList = gameDao.getNextGames( numberOfGames );
        List<GameDto> gameDtoList = new ArrayList<>();
        
        for ( Game gameEntity : gameEntityList ) {
            GameDto gameDto = gameMatchConverter.convertGameEntityToGameDto( gameEntity );
            gameDtoList.add( gameDto );
        }
        return gameDtoList;
    }

    public List<GameDto> getAllGames() {
        List<Game> gameEntityList = gameDao.getAllGames();
        List<GameDto> gameDtoList = new ArrayList<>();
        
        for ( Game gameEntity : gameEntityList ) {
            GameDto gameDto = gameMatchConverter.convertGameEntityToGameDto( gameEntity );
            gameDtoList.add( gameDto );
        }
        return gameDtoList;
    }

    public ResponseJson deleteGameById( int gameId ) {
        // TODO Auto-generated method stub
        return null;
    }

    public ResponseJson updateGame( GameDto gameDto ) {
        try {
            gameValidator.validateUpdatedGame( gameDto );
            Game game = gameMatchConverter.convertGameDtoToGame( gameDto );
            //gameDao.updateGame( game );
            return new ResponseJson( UPDATE, true, game.getId() );
        } catch( GameException e ) {
            e.printStackTrace();
        }

        return new ResponseJson( UPDATE, false );
    }

}
