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
    private String apiKey = "RGAPI-ea2523fe-d8ce-4f98-b0ba-bf17da33f07d";
    public SummonerDTO getSummoner(String summonorid) {
        return restTemplate.exchange(requestSummonerUrl, HttpMethod.GET, null, SummonerDTO.class, summonorid, apiKey).getBody();
    }

    public LeaguePositionDTO getLeaguePosition(String encryptid) {
        return restTemplate.exchange(requestPositionUrl, HttpMethod.GET, null, LeaguePositionDTO.class, encryptid, apiKey).getBody();
    }

}