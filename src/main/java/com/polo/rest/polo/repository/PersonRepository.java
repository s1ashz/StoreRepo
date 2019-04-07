package com.polo.rest.polo.repository;

import org.springframework.data.repository.CrudRepository;

import com.polo.rest.polo.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findFirstByNameAndNumber( String personName, int personNumber );
    Person findFirstByNameAndType( String coachName, String personType );

}
