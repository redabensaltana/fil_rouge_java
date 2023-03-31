package com.redabens.restosir.repositories;

import com.redabens.restosir.entities.Waiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaiterRepo extends JpaRepository <Waiter, Integer> {
    Waiter findByEmail(String email);
}
