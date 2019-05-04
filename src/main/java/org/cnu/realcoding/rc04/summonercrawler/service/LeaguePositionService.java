package org.cnu.realcoding.rc04.summonercrawler.service;

import org.cnu.realcoding.rc04.summonercrawler.domain.LeaguePositionDTO;
import org.springframework.stereotype.Service;

@Service
public class LeaguePositionService {

    public LeaguePositionDTO getLeaguePositionByID(String summonerId) {
        // 어차피 SummonerDTO중, id값만 사용하는데 굳이 필요한가?
        // SummonerDTO 삭제할수도 있음


        // 소환사 이름으로, 반환할 LeaguePositionDTO 객체 받아오기
        LeaguePositionDTO leaguePositionDTO = null;

        // if(db에 이미 소환사 정보 있는지 검사)
        // 없으면 db에 새로 삽입
        // 있으면 업데이트

        leaguePositionRepository.insertLeaguePosition(leaguePositionDTO);

        return leaguePositionDTO;
    }

}
