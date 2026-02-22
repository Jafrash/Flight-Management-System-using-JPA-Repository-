package org.hartford.mapping_demo.repository;

import org.hartford.mapping_demo.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team,Long> {
}
