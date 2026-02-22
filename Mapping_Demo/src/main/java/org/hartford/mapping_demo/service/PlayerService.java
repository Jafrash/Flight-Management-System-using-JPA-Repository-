package org.hartford.mapping_demo.service;

import org.hartford.mapping_demo.model.Player;
import org.hartford.mapping_demo.repository.PlayerRepo;

import java.util.List;

public class PlayerService {
    PlayerRepo playerRepo;

    public List<Player>getAllPlayers(){
        return playerRepo.findAll();
    }

    public Player getPlayerById(Long id){
        return playerRepo.findById(id).orElse(null);
    }

    public Player addPlayer(Player player){
            return playerRepo.save(player);
    }


}
