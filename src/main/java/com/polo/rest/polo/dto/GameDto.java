package com.polo.rest.polo.dto;

import java.util.List;

import com.polo.rest.polo.entity.GameEvent;
import com.polo.rest.polo.entity.GameInformationJson;

public class GameDto
{

    private long id;
    private TeamDto homeTeam;
    private TeamDto awayTeam;
    private GameInformationJson gameInformationJson;
    private String date;
    private List<GameEvent> activity;
    
    public long getId() {
        return id;
    }
    public void setId( long id ) {
        this.id = id;
    }
    public TeamDto getHomeTeam() {
        return homeTeam;
    }
    public void setHomeTeam( TeamDto homeTeam ) {
        this.homeTeam = homeTeam;
    }
    public TeamDto getAwayTeam() {
        return awayTeam;
    }
    public void setAwayTeam( TeamDto awayTeam ) {
        this.awayTeam = awayTeam;
    }
    public List<GameEvent> getActivity() {
        return activity;
    }
    public void setActivity( List<GameEvent> activity ) {
        this.activity = activity;
    }
	public GameInformationJson getGameInformationJson() {
		return gameInformationJson;
	}
	public void setGameInformationJson( GameInformationJson gameInformationJson ) {
		this.gameInformationJson = gameInformationJson;
	}
    public String getDate() {
        return date;
    }
    public void setDate( String date ) {
        this.date = date;
    }
    
    @Override
    public String toString() {
        return "GameDto [id=" + id + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", gameInformationJson="
                + gameInformationJson + ", date=" + date + ", activity=" + activity + "]";
    }
    
}
