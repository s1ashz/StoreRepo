package com.polo.rest.polo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polo.rest.polo.constants.ConstantManager;
import com.polo.rest.polo.dto.PersonDto;
import com.polo.rest.polo.exceptions.PersonException;
import com.polo.rest.polo.responses.ResponseJson;
import com.polo.rest.polo.service.PersonService;

@RestController
public class PersonControllerImpl implements ConstantManager {

	private static final Logger LOGGER = LoggerFactory.getLogger( PersonControllerImpl.class );
	
    @Autowired
    private PersonService personService;
    
    @RequestMapping( PERSON_CREATE )
    public ResponseJson createPerson( @RequestBody( required=true ) PersonDto personDto ) {
        return personService.createPerson( personDto );
    }
    
    @RequestMapping( PERSON_GET ) 
    public PersonDto getPerson( @PathVariable(value="personName", required=true ) String personName, 
    		@PathVariable(value="personId", required=true ) int personId ) throws PersonException {
        return personService.getPerson( personName, personId );
    }
    
    @RequestMapping( PERSON_GET_ALL )
    public List<PersonDto> getAllPerson() {
        return personService.getAllPersons();
    }
    
    @RequestMapping( PERSON_DELETE_BY_ID )
    public ResponseJson deletePerson( @PathVariable(value="id", required=true ) int personId ) throws PersonException {
        return personService.deletePersonById( personId );
    }
    
    @RequestMapping( PERSON_UPDATE )
    public ResponseJson updatePerson( @RequestBody( required=true ) PersonDto personDto ) throws PersonException {
        return personService.updatePerson( personDto );
    }
    
}
