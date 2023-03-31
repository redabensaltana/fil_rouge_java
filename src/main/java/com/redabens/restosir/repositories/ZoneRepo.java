package com.redabens.restosir.repositories;

import com.redabens.restosir.entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepo extends JpaRepository<Zone, Integer> {
}
