package com.polo.rest.polo.dto;

public class PersonDto {
    
    private String name;
    private int number;
    private String type;
    private String team;
    
    public String getTeam() {
		return team;
	}
	public void setTeam( String team ) {
		this.team = team;
	}
	public String getName() {
        return name;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber( int number ) {
        this.number = number;
    }
    public String getType() {
        return type;
    }
    public void setType( String type ) {
        this.type = type;
    }
	@Override
	public String toString() {
		return "PersonDto [name=" + name + ", number=" + number + ", type=" + type + ", team=" + team + "]";
	}
    
    
}
