package org.hartford.mapping_demo.controller;

import org.hartford.mapping_demo.model.Team;
import org.hartford.mapping_demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teams")

public class TeamController {
    @Autowired
    TeamService teamService;

    @GetMapping
    public List<Team>getAllTeams(){
        return teamService.getAllItems();
    }

    @GetMapping("/{id}")
    public Team getTeamById(Long id){
        return teamService.getTeamById(id);
    }

    @PostMapping
    public Team addTeam(Team team){
        return teamService.addTeam(team);
    }

}
