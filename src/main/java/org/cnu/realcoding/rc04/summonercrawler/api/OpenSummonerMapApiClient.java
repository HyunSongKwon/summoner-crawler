package org.cnu.realcoding.rc04.summonercrawler.api;

import org.cnu.realcoding.rc04.summonercrawler.domain.LeaguePositionDTO;
import org.cnu.realcoding.rc04.summonercrawler.domain.SummonerDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenSummonerMapApiClient {

    @Autowired
    private RestTemplate restTemplate;
    private String requestSummonerUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonorid}?api_key={API_KEY}";
    private String requestPositionUrl = "https://kr.api.riotgames.com/lol/league/v4/positions/by-summoner/{encryptid}?api_key={API_KEY}";

    public SummonerDTO getSummoner(String summonorid) {
        return restTemplate.exchange(requestSummonerUrl, HttpMethod.GET, null, SummonerDTO.class, summonorid, "RGAPI-e836634b-0e1a-4b1b-b44c-e4495f8cb191").getBody();
    }

    public LeaguePositionDTO getLeaguePosition(String encryptid) {
        return restTemplate.exchange(requestPositionUrl, HttpMethod.GET, null, LeaguePositionDTO.class, encryptid, "RGAPI-e836634b-0e1a-4b1b-b44c-e4495f8cb191").getBody();
    }

}