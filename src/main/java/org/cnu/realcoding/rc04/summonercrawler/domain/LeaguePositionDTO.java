package org.cnu.realcoding.rc04.summonercrawler.domain;

import lombok.Data;

@Data
public class LeaguePositionDTO {
    String queueType;
    String summonerName;
    boolean hotStreak;
    int wins;
    boolean veteran;
    int looses;
    String rank;
    String leagueId;
    boolean inactive;
    boolean freshBlood;
    String leagueName;
    String position;
    String tier;
    String summonerId;
    int leaguePoints;
}
