package com.polo.rest.polo.dto;

public class TeamDto {
    
    private String name;
    private String logo;
    private String acronym;
    
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
    public String getAcronym() {
		return acronym;
	}
	public void setAcronym( String acronym ) {
		this.acronym = acronym;
	}
	
    @Override
    public String toString() {
        return "TeamDto [name=" + name + ", logo=" + logo + ", acronym=" + acronym + "]";
    }

}
