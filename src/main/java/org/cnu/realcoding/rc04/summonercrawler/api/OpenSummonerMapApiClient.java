package org.cnu.realcoding.rc04.summonercrawler.api;

import org.cnu.realcoding.rc04.summonercrawler.domain.LeaguePositionDTO;
import org.cnu.realcoding.rc04.summonercrawler.domain.SummonerDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.databind.ObjectMapper;
import springfox.documentation.spring.web.json.Json;

@Service
public class OpenSummonerMapApiClient {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper mapper;

    private String requestSummonerUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonorid}?api_key={API_KEY}";
    private String requestPositionUrl = "https://kr.api.riotgames.com/lol/league/v4/positions/by-summoner/{encryptid}?api_key={API_KEY}";
    private String apiKey = "RGAPI-809bb1d1-e87b-4a0a-8de1-3ccef7d5f40e";

    public SummonerDTO getSummoner(String summonorid) {
        return restTemplate.exchange(requestSummonerUrl, HttpMethod.GET, null, SummonerDTO.class, summonorid, apiKey).getBody();
    }

    public LeaguePositionDTO getLeaguePosition(String encryptid) {
        HashSet leaguePositionDTOSet = restTemplate.exchange(requestPositionUrl, HttpMethod.GET, null, HashSet.class, encryptid, apiKey).getBody();

        Iterator iterator = leaguePositionDTOSet.iterator();
        LeaguePositionDTO leaguePositionDTO = mapper.convertValue(iterator.next(), LeaguePositionDTO.class);

        return leaguePositionDTO;
    }
}