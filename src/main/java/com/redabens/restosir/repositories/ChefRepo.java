package com.redabens.restosir.repositories;

import com.redabens.restosir.entities.Chef;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChefRepo extends JpaRepository <Chef, Integer> {
    Chef findByEmail(String email);
}
