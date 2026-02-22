package org.hartford.mapping_demo.controller;

import org.hartford.mapping_demo.model.Player;
import org.hartford.mapping_demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayerById(Long id){
        return playerService.getPlayerById(id);
    }

    @PostMapping
    public Player addPlayer(Player player){
        return playerService.addPlayer(player);
    }



}
