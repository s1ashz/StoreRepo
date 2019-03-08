package com.polo.rest.polo.dto;

import java.util.List;

import com.polo.rest.polo.entity.GameEvent;

public class GameDto
{

    private long id;
    private TeamDto homeTeam;
    private TeamDto awayTeam;

    private String gameInformationJson;
    
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
    public List<String> getRefereeList() {
        return refereeList;
    }
    public void setRefereeList( List<String> refereeList ) {
        this.refereeList = refereeList;
    }
    public List<GameEvent> getActivity() {
        return activity;
    }
    public void setActivity( List<GameEvent> activity ) {
        this.activity = activity;
    }
    
	@Override
	public String toString() {
		return "GameDto [id=" + id + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", refereeList=" + refereeList + ", activity=" + activity + "]";
	}
    
}
