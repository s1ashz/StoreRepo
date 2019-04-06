package com.polo.rest.polo.dto;

import java.util.Date;
import java.util.List;

import com.polo.rest.polo.entity.GameEvent;
import com.polo.rest.polo.entity.GameInformationJson;

public class GameDto {

	private long id;
	private TeamDto homeTeam;
	private TeamDto awayTeam;
	private GameInformationJson gameInformationJson;
	private Date date;
	private List<GameEvent> activity;
	private String competition;
	private String local;
	private int round;
	private long time;
	
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
	public GameInformationJson getGameInformationJson() {
		return gameInformationJson;
	}
	public void setGameInformationJson( GameInformationJson gameInformationJson ) {
		this.gameInformationJson = gameInformationJson;
	}
	public Date getDate() {
		return date;
	}
	public void setDate( Date date ) {
		this.date = date;
	}
	public List<GameEvent> getActivity() {
		return activity;
	}
	public void setActivity( List<GameEvent> activity ) {
		this.activity = activity;
	}
	public String getCompetition() {
		return competition;
	}
	public void setCompetition( String competition ) {
		this.competition = competition;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal( String local ) {
		this.local = local;
	}
	public int getRound() {
		return round;
	}
	public void setRound( int round ) {
		this.round = round;
	}
	public long getTime() {
		return time;
	}
	public void setTime( long time ) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "GameDto [id=" + id + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", gameInformationJson=" + gameInformationJson + ", date=" + date + ", activity=" + activity + ", competition=" + competition + ", local=" + local + ", round="
				+ round + ", time=" + time + "]";
	}

	
}
