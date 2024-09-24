package org.example.service;


import org.example.entities.League;
import org.example.entities.TeamStats;
import org.example.repository.TeamStatRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeamStatService extends ServiceManager<TeamStats, Integer>  {
	private final TeamStatRepository teamStatRepository;
	private final LeagueService leagueService;
	
	public TeamStatService() {
		this(new TeamStatRepository());
	}
	
	private TeamStatService(TeamStatRepository repository) {
		super(repository);
		this.teamStatRepository = repository;
		this.leagueService = new LeagueService();
	}

	public List<TeamStats> findAllLeagueId(Integer leagueId) {
		Optional<League> optionalLeague = leagueService.findById(leagueId);
		if (optionalLeague.isPresent()) {
			League league = optionalLeague.get();
			List<TeamStats> teamStatsList = findByFieldNameAndValue("teamLeague", league);
			return teamStatsList;
		}
		return new ArrayList<>();
	}
}