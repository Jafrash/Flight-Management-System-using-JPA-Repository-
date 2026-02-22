package org.hartford.mapping_demo.repository;

import org.hartford.mapping_demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person,Long> {
}
