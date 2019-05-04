package org.cnu.realcoding.rc04.summonercrawler.repository;

import org.cnu.realcoding.rc04.summonercrawler.domain.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SummonerRepository {
    // 이거 들어가야되나??? DB에 저장 안하면 필요 없지 않아?
    @Autowired
    private MongoTemplate mongoTemplate;

    public void insertSummonerDTO(SummonerDTO summonerDTO){
        mongoTemplate.insert(summonerDTO);
    }
}
