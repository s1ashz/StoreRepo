package com.polo.rest.polo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.polo.rest.polo.entity.Game;

public interface GameRepository extends CrudRepository<Game, Long>{

    Game findGameById(long gameId);
    
    @Query(nativeQuery = true, value="SELECT TOP :numberOfGames * FROM Game gm order by cast(gm.date as int) DESC Limit 3")
    List<Game> findTop5ByOrderByDateDesc( @Param("numberOfGames") int numberOfGames );
    
}
