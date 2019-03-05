package com.polo.rest.polo.repository;

import org.springframework.data.repository.CrudRepository;

import com.polo.rest.polo.entity.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

	Team findAllByName( String teamName );
	boolean existsByName( String teamName );

}
