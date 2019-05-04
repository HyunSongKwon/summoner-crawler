package org.cnu.realcoding.rc04.summonercrawler.controller;
import org.cnu.realcoding.rc04.summonercrawler.domain.LeaguePositionDTO;
import org.cnu.realcoding.rc04.summonercrawler.service.LeaguePositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/summoner-crawler")
public class SummonerController {
    @Autowired
    private LeaguePositionService leaguePositionService;

    @GetMapping("/{summonerId}")
    public LeaguePositionDTO getLeaguePositionDTOById(@PathVariable String summonerId) {
        return leaguePositionService.getLeaguePositionByID(summonerId);
    }
}
