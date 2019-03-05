package com.polo.rest.polo.dto;

import java.util.List;

public class TeamDto {
    
    private String name;
    private String logo;
    private List<PersonDto> players;
    private List<String> coaches;
    
    public String getName() {
        return name;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public String getLogo() {
        return logo;
    }
    public void setLogo( String logo ) {
        this.logo = logo;
    }
    public List<PersonDto> getPlayers() {
        return players;
    }
    public void setPlayers( List<PersonDto> players ) {
        this.players = players;
    }
    public List<String> getCoaches() {
        return coaches;
    }
    public void setCoaches( List<String> coaches ) {
        this.coaches = coaches;
    }
    
    @Override
    public String toString() {
        return "TeamDto [name=" + name + ", logo=" + logo + ", players=" + players + ", coaches=" + coaches + "]";
    }

}