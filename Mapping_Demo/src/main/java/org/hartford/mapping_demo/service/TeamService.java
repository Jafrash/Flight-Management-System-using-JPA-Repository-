package org.hartford.mapping_demo.service;

import org.hartford.mapping_demo.model.Team;
import org.hartford.mapping_demo.repository.TeamRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    TeamRepo teamRepo;



    public Team getTeamById(Long id){
        return teamRepo.findById(id).orElse(null);
    }

    public Team addTeam(Team team){
        return teamRepo.save(team);
    }


    public List<Team> getAllItems() {
        return teamRepo.findAll();
    }
}
