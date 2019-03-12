package com.polo.rest.polo.validators;

import org.springframework.stereotype.Component;

import com.polo.rest.polo.constants.ConstantManager;
import com.polo.rest.polo.dto.GameDto;
import com.polo.rest.polo.exceptions.GameException;

@Component
public class GameValidator implements ConstantManager {

    public void validateGame( GameDto gameDto ) throws GameException {
        checkGameNull( gameDto );
    }
    
    public void validateUpdatedGame( GameDto gameDto ) throws GameException {
        checkGameNull( gameDto );
        checkGameHasId( gameDto );
    }

    private void checkGameHasId( GameDto gameDto ) throws GameException {
        if ( 0 == gameDto.getId() ) {
            throwGameException( EXCEPTION_UPDATED_GAME_ID_NULL );
        }
    }

    private void checkGameNull( GameDto gameDto ) throws GameException {
        if ( null == gameDto ) {
            throwGameException( EXCEPTION_GAME_NULL );
        }
    }
    
    private Exception throwGameException( String message ) throws GameException {
        throw new GameException( message );
    }

}
