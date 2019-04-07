
package com.polo.rest.polo.entity;

import java.util.List;

public class Participants {

    private List<Person> homeTeamPlayerList;
    private List<Person> awayTeamPlayerList;
    private List<Person> homeTeamCoachList;
    private List<Person> awayTeamCoachList;
    private List<Person> refereeList;
    
    
    public List<Person> getHomeTeamPlayerList() {
		return homeTeamPlayerList;
	}
	public void setHomeTeamPlayerList( List<Person> homeTeamPlayerList ) {
		this.homeTeamPlayerList = homeTeamPlayerList;
	}
	public List<Person> getAwayTeamPlayerList() {
		return awayTeamPlayerList;
	}
	public void setAwayTeamPlayerList( List<Person> awayTeamPlayerList ) {
		this.awayTeamPlayerList = awayTeamPlayerList;
	}
	public List<Person> getHomeTeamCoachList() {
		return homeTeamCoachList;
	}
	public void setHomeTeamCoachList( List<Person> homeTeamCoachList ) {
		this.homeTeamCoachList = homeTeamCoachList;
	}
	public List<Person> getAwayTeamCoachList() {
		return awayTeamCoachList;
	}
	public void setAwayTeamCoachList( List<Person> awayTeamCoachList ) {
		this.awayTeamCoachList = awayTeamCoachList;
	}
	public List<Person> getRefereeList() {
		return refereeList;
	}
	public void setRefereeList( List<Person> refereeList ) {
		this.refereeList = refereeList;
	}

	@Override
    public String toString() {
        return "GamePlayersInformationJson [homeTeamPlayerList=" + homeTeamPlayerList + ", awayTeamPlayerList=" + awayTeamPlayerList
                + ", homeTeamCoacheList=" + homeTeamCoachList + ", awayTeamCoacheList=" + awayTeamCoachList + ", refereeList="
                + refereeList + "]";
    }
    
}
