
package com.polo.rest.polo.entity;

import java.util.List;

public class GameInformationJson {

    private List<Person> homeTeamPlayerList;
    private List<Person> awayTeamPlayerList;
    private List<Person> homeTeamCoacheList;
    private List<Person> awayTeamCoacheList;
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
    public List<Person> getHomeTeamCoacheList() {
        return homeTeamCoacheList;
    }
    public void setHomeTeamCoacheList( List<Person> homeTeamCoacheList ) {
        this.homeTeamCoacheList = homeTeamCoacheList;
    }
    public List<Person> getAwayTeamCoacheList() {
        return awayTeamCoacheList;
    }
    public void setAwayTeamCoacheList( List<Person> awayTeamCoacheList ) {
        this.awayTeamCoacheList = awayTeamCoacheList;
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
                + ", homeTeamCoacheList=" + homeTeamCoacheList + ", awayTeamCoacheList=" + awayTeamCoacheList + ", refereeList="
                + refereeList + "]";
    }
    
}
