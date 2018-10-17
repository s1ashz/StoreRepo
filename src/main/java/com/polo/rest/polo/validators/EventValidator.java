package com.polo.rest.polo.validators;

import static com.polo.rest.polo.constants.ExceptionMessages.EXCEPTION_EVENT_TARGET_NULL;
import static com.polo.rest.polo.constants.ExceptionMessages.EXCEPTION_INVALID_ACCOUNT_MESSAGE;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.stereotype.Component;

import com.polo.rest.polo.dto.EventDto;
import com.polo.rest.polo.exceptions.EventException;

@Component
public class EventValidator
{

    public void validateEvent( EventDto eventDto) throws EventException {
        for ( Field eventField: eventDto.getClass().getDeclaredFields() ) {
            eventField.setAccessible(true);
                try {
                    validateAccountField(eventDto, eventField);
                    validateTarget(eventField, eventDto);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
        }
    }

    private void validateTarget(Field eventField, EventDto targettDto) throws IllegalAccessException, EventException {
        if ( checkFieldIsTargetDto( eventField ) && !checkFieldNull(targettDto, eventField) ) {
            if ( 0 == targettDto.getTarget().size() ) throw new EventException( EXCEPTION_EVENT_TARGET_NULL);
            for ( String targetDto : targettDto.getTarget() ) {
                if ( null == targetDto ) {
                    throw new EventException( EXCEPTION_EVENT_TARGET_NULL);
                }
            }
        }
    }

    private void validateAccountField(EventDto eventDto, Field eventField) throws IllegalAccessException, EventException {
        if ( !checkFieldIsTargetDto(eventField) && !checkFieldIsId(eventField) && checkFieldNull(eventDto, eventField) ) {
            throw new EventException( EXCEPTION_INVALID_ACCOUNT_MESSAGE + eventField.getName() );
        }
    }

    private boolean checkFieldIsId( Field eventField ) {
        return eventField.getType().getSimpleName().equals("long");
    }

    private boolean checkFieldNull(EventDto eventDto, Field eventField) throws IllegalAccessException {
        return null == eventField.get(eventDto);
    }

    private boolean checkFieldIsTargetDto(Field eventField) {
        return eventField.getType().getSimpleName().equals(List.class.getSimpleName() );
    }
    
    
}
