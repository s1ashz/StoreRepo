package com.polo.rest.polo.validators;

import org.springframework.stereotype.Component;

import com.polo.rest.polo.constants.ConstantManager;
import com.polo.rest.polo.dto.TeamDto;
import com.polo.rest.polo.exceptions.TeamException;

@Component
public class TeamValidator implements ConstantManager {

	public void validateTeam( TeamDto teamDto ) throws TeamException {
	    checkNull( teamDto );
	    checkFieldsNull( teamDto );
	}

    private void checkNull( TeamDto teamDto ) throws TeamException {
        if ( null == teamDto ) {
            throwTeamException( EXCEPTION_TEAM_NULL );
        }
    }
    
    private void checkFieldsNull( TeamDto teamDto ) throws TeamException {
        if ( null == teamDto.getName() ) {
            throwTeamException( EXCEPTION_TEAM_NAME_NULL );
        }
    }

    private Exception throwTeamException( String message ) throws TeamException {
        throw new TeamException( message );
    }
    
    
}
