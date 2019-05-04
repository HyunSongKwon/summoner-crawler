package org.cnu.realcoding.rc04.summonercrawler.service;

import org.cnu.realcoding.rc04.summonercrawler.api.OpenSummonerMapApiClient;
import org.cnu.realcoding.rc04.summonercrawler.domain.LeaguePositionDTO;
import org.cnu.realcoding.rc04.summonercrawler.domain.SummonerDTO;
import org.cnu.realcoding.rc04.summonercrawler.repository.LeaguePositionRepository;
import org.cnu.realcoding.rc04.summonercrawler.repository.SummonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.AccumulatorOperators;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class LeaguePositionService {
    @Autowired
    private OpenSummonerMapApiClient openSummonerMapApiClient;
    @Autowired
    private SummonerRepository summonerRepository;
    @Autowired
    private LeaguePositionRepository leaguePositionRepository;

    public LeaguePositionDTO getLeaguePositionByID(String summonerId) {

        SummonerDTO summonerDTO = openSummonerMapApiClient.getSummoner(summonerId);
        LeaguePositionDTO leaguePositionDTO = openSummonerMapApiClient.getLeaguePosition(summonerDTO.getId());
        leaguePositionRepository.insertLeaguePosition(leaguePositionDTO);
        return leaguePositionDTO;
    }


}
