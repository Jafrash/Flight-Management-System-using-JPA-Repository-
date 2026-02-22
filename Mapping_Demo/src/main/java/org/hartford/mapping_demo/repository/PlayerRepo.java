package org.hartford.mapping_demo.repository;

import org.hartford.mapping_demo.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<Player,Long> {
}
