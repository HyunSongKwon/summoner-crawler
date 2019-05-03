package org.cnu.realcoding.rc04.summonercrawler.repository;

import org.cnu.realcoding.rc04.summonercrawler.domain.LeaguePositionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LeaguePositionRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void insertLeaguePosition(LeaguePositionDTO leaguePositionDTO){
        mongoTemplate.insert(leaguePositionDTO);
    }
}
