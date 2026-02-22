package org.hartford.mapping_demo.repository;

import org.hartford.mapping_demo.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepo extends JpaRepository<Passport,Long> {
}
