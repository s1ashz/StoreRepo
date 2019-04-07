package com.polo.rest.polo.repository;

import org.springframework.data.repository.CrudRepository;

import com.polo.rest.polo.entity.GameEvent;

public interface GameEventRepository extends CrudRepository<GameEvent, Long>{

	GameEvent findGameEventById( long gameEventId );

}
