package com.redabens.restosir.repositories;

import com.redabens.restosir.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepo extends JpaRepository<Seat, Integer> {
    List<Seat> findByZone(Integer zone);
}




