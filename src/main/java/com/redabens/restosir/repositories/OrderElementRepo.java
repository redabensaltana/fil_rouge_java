package com.redabens.restosir.repositories;

import com.redabens.restosir.entities.OrderElement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderElementRepo extends JpaRepository<OrderElement, Integer> {
}
