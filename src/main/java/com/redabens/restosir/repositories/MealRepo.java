package com.redabens.restosir.repositories;

import com.redabens.restosir.entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MealRepo extends JpaRepository <Meal, Integer> {
    List<Meal> findByCategory(Integer category);

}
