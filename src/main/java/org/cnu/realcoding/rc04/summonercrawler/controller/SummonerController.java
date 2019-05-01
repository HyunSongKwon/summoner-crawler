package org.cnu.realcoding.rc04.summonercrawler.controller;
import org.cnu.realcoding.rc04.summonercrawler.service.LeaguePositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummonerController {

    @Autowired
    private LeaguePositionService leaguePositionService;
}
