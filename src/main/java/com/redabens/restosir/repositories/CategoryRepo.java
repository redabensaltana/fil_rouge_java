package com.redabens.restosir.repositories;

import com.redabens.restosir.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepo extends JpaRepository <Category, Integer> {
}
