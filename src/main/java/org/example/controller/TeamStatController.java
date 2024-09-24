package org.example.controller;

import org.example.entities.Manager;
import org.example.entities.TeamStats;
import org.example.service.TeamStatService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeamStatController {

    private final TeamStatService teamStatService;

    public TeamStatController() {
        this.teamStatService = TeamStatService.getInstance();
    }

    public Optional<TeamStats> findById(int id) {
        try {
            return teamStatService.findById(id);
        } catch (Exception e) {
            System.out.println("Controller: TeamStat bulma sırasında hata oluştu... " + e.getMessage());
        }
        return Optional.empty();
    }

    public List<TeamStats> findAll() {
        try {
            return teamStatService.findAll();
        }
        catch (Exception e) {
            System.out.println("Controller: TeamStat listeleme sırasında hata oluştu... " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public TeamStats update(TeamStats teamStat) {
       return teamStatService.update(teamStat);
    }

    public List<TeamStats> findAllLeagueId(Integer leagueId) {
        return teamStatService.findAllLeagueId(leagueId);
    }
}
