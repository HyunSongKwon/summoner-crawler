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
        // 어차피 SummonerDTO중, id값만 사용하는데 굳이 필요한가?

        SummonerDTO summonerDTO = openSummonerMapApiClient.getSummoner(summonerId);

        // 소환사 이름으로, 반환할 LeaguePositionDTO 객체 받아오기
        LeaguePositionDTO leaguePositionDTO = openSummonerMapApiClient.getLeaguePosition(summonerDTO.getId());
        // if(db에 이미 소환사 정보 있는지 검사)
        // 없으면 db에 새로 삽입
        // 있으면 업데이트

        getCurrentLeaguePositionPeriodically(summonerId);

        return leaguePositionDTO;
    }

    //@Scheduled(initialDelay = 5000L, fixedDelay = 2000L)
    public void getCurrentLeaguePositionPeriodically(String summonerId){
        SummonerDTO summonerDTO = openSummonerMapApiClient.getSummoner(summonerId);
        LeaguePositionDTO leaguePositionDTO = openSummonerMapApiClient.getLeaguePosition(summonerDTO.getId());
        leaguePositionRepository.insertLeaguePosition(leaguePositionDTO);
    }
}
