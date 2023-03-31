package com.redabens.restosir.repositories;

import com.redabens.restosir.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
