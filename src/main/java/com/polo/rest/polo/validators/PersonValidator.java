package com.polo.rest.polo.validators;

import org.springframework.stereotype.Component;

import com.polo.rest.polo.constants.ConstantManager;
import com.polo.rest.polo.dto.PersonDto;
import com.polo.rest.polo.exceptions.PersonException;

@Component
public class PersonValidator implements ConstantManager {

    public void validatePerson( PersonDto personDto) throws PersonException {
        checkPersonNull( personDto );
        checkPersonHasName( personDto );
    }
    
    private void checkPersonNull( PersonDto personDto ) throws PersonException {
    	if ( null == personDto ) {
    		throwPersonException( EXCEPTION_PERSON_NULL );
    	}
    }
    
    private void checkPersonHasName( PersonDto personDto ) throws PersonException {
        if ( null == personDto.getName() ) {
            throwPersonException( EXCEPTION_UPDATED_PERSON_ID_NULL );
        }
    }
    
    private Exception throwPersonException( String message ) throws PersonException {
        throw new PersonException( message );
    }

}
