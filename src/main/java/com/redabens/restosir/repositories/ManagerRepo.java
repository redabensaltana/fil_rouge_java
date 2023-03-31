package com.redabens.restosir.repositories;

import com.redabens.restosir.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ManagerRepo extends JpaRepository <Manager, Integer> {
    Manager findByEmail(String email);
}

