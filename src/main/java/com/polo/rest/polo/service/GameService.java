package com.polo.rest.polo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polo.rest.polo.convertor.GameMatchConverter;
import com.polo.rest.polo.dao.GameDao;
import com.polo.rest.polo.dto.EventDto;
import com.polo.rest.polo.dto.GameDto;
import com.polo.rest.polo.entity.Game;
import com.polo.rest.polo.exceptions.GameException;
import com.polo.rest.polo.responses.ResponseJson;
import com.polo.rest.polo.validators.GameValidator;

@Service
public class GameService {

    @Autowired
    private GameDao gameDao;
    
    @Autowired
    private GameValidator gameValidator;
    
    @Autowired
    private GameMatchConverter gameMatchConverter;
    
    public ResponseJson createGame( GameDto gameDto ) {
        gameValidator.validateGame( gameDto );
        
        Game game = gameMatchConverter.convertGameDtoToGame( gameDto );
        
        try {
            gameDao.createGame( game );
        } catch( GameException e ) {
            e.printStackTrace();
        }
        
        
        return null;
    }

    public EventDto getGame( Long gameId ) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<EventDto> getAllGames() {
        // TODO Auto-generated method stub
        return null;
    }

    public ResponseJson deleteGameById( int gameId ) {
        // TODO Auto-generated method stub
        return null;
    }

    public ResponseJson updateGame( GameDto eventDto ) {
        // TODO Auto-generated method stub
        return null;
    }

}
