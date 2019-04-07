package com.polo.rest.polo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polo.rest.polo.constants.ConstantManager;
import com.polo.rest.polo.convertor.GameMatchConverter;
import com.polo.rest.polo.dao.PersonDao;
import com.polo.rest.polo.dto.PersonDto;
import com.polo.rest.polo.entity.Person;
import com.polo.rest.polo.exceptions.PersonException;
import com.polo.rest.polo.responses.ResponseJson;
import com.polo.rest.polo.validators.PersonValidator;

@Service
public class PersonService implements ConstantManager {

	@Autowired
    private PersonDao personDao;
    
    @Autowired
    private PersonValidator personValidator;
    
    @Autowired
    private GameMatchConverter gameMatchConverter;
    
    public ResponseJson createPerson( PersonDto personDto ) {
        try {
        	personValidator.validatePerson( personDto );
        	Person person = gameMatchConverter.convertPersonDtoToPerson( personDto );
            personDao.createPerson( person );

            return new ResponseJson( CREATE, true, person.getId() );
        } catch( PersonException e ) {
            e.printStackTrace();
        }
        return new ResponseJson( CREATE, false );
    }

    public PersonDto getPerson( String personName, int personId ) throws PersonException {
    	Person personEntity = personDao.getPersonByNameAndNumber( personName, personId );
        PersonDto personDto = gameMatchConverter.convertPersonEntityToPersonDto( personEntity );
        return personDto;
    }
    
    public List<PersonDto> getAllPersons() {
        List<Person> personEntityList = personDao.getAllPersons();
        List<PersonDto> personDtoList = new ArrayList<>();
        
        for ( Person personEntity : personEntityList ) {
        	PersonDto personDto = gameMatchConverter.convertPersonEntityToPersonDto( personEntity );
            personDtoList.add( personDto );
        }
        return personDtoList;
    }

    public ResponseJson deletePersonById( int gameId ) {
        return new ResponseJson( "NOT IMPLEMENTED", false );
    }

    public ResponseJson updatePerson( PersonDto personDto ) {
        try {
        	personValidator.validatePerson( personDto );
            Person personEntity = gameMatchConverter.convertPersonDtoToPerson( personDto );
            personDao.updatePerson( personEntity );
            return new ResponseJson( UPDATE, true, personEntity.getId() );
        } catch( PersonException e ) {
            e.printStackTrace();
        }

        return new ResponseJson( UPDATE, false );
    }
	
	
}
