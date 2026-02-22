package org.hartford.mapping_demo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy="team")
    List<Player> players;

    public Team(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Team() {
    }




}
