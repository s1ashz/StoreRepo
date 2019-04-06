package com.polo.rest.polo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GameEvent {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String gameEventType;
    private int team;
    private String playerName;
    private int period;
    private long time;
    
	public long getId() {
		return id;
	}
	public void setId( long id ) {
		this.id = id;
	}
	public String getGameEventType() {
		return gameEventType;
	}
	public void setGameEventType( String gameEventType ) {
		this.gameEventType = gameEventType;
	}
	public int getTeam() {
		return team;
	}
	public void setTeam( int team ) {
		this.team = team;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName( String playerName ) {
		this.playerName = playerName;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod( int period ) {
		this.period = period;
	}
	public long getTime() {
		return time;
	}
	public void setTime( long time ) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "GameEvent [id=" + id + ", gameEventType=" + gameEventType + ", team=" + team + ", playerName=" + playerName + ", period=" + period + ", time=" + time + "]";
	}
	
    
}
