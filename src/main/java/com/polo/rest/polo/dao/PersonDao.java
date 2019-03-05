package com.polo.rest.polo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.polo.rest.polo.constants.ConstantManager;
import com.polo.rest.polo.entity.Person;
import com.polo.rest.polo.exceptions.PersonException;
import com.polo.rest.polo.repository.PersonRepository;

@Repository
public class PersonDao implements ConstantManager {

    @Autowired
    private PersonRepository personRepository;
    
    public Long createPerson( Person person) throws PersonException {
        Person personPersisted = personRepository.save( person );
        if ( 0 == personPersisted.getId() ) throw new PersonException( EXCEPTION_PERSON_NOT_CREATED ); 
        return personPersisted.getId();
    }
    
    public Person getPersonByNameAndNumber( String personName, String personNumber ) throws PersonException {
        return personRepository.findFirstByNameAndNumber( personName, personNumber );
    }

    public List<Person> getAllPersons() {
        return (List<Person>) personRepository.findAll();
    }

    public void deletePersonById( long id ) {
        personRepository.deleteById( id );
    }

    public void updatePerson( Person event ) {
        personRepository.save( event );
    }

    public boolean checkPersonExists( long id ) {
        return personRepository.existsById( id );
    }

    public Person getPersonCoachesByName( String coachName ) {
        return personRepository.findFirstByNameAndType( coachName, COACH );
    }

    public Person getPersonRefereeByName( String refereeName ) {
        return personRepository.findFirstByNameAndType( refereeName, REFEREE );
    }
    
    
}
