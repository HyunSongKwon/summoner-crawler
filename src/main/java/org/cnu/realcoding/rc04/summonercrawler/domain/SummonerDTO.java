package org.cnu.realcoding.rc04.summonercrawler.domain;

import lombok.Data;

@Data
public class SummonerDTO {
    int profileIconId;
    String name;
    String puuid;
    long summonerLevel;
    long revisionDate;
    String id;
    String accountId;
}
