package com.redabens.restosir.services;

import com.redabens.restosir.dto.MealDto;
import com.redabens.restosir.entities.Category;
import com.redabens.restosir.entities.Meal;
import com.redabens.restosir.entities.Seat;
import com.redabens.restosir.repositories.CategoryRepo;
import com.redabens.restosir.repositories.MealRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    @Autowired
    private MealRepo mealRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    public List<Meal> getAll() {
        return mealRepo.findAll();
    }

    public List<Meal> getAllWhere(Integer category) {
        //update to entity
        return mealRepo.findByCategory(category);
    }

    public Meal getMealById(int id) {
        return mealRepo.findById(id).get();
    }

    public Meal saveMeal(MealDto mealDto) {
        Meal meal = new Meal();
        meal.setName(mealDto.getName());
        meal.setPrice(mealDto.getPrice());
        Category category = categoryRepo.findById(mealDto.getCategory()).get();
        meal.setCategory(category);

        return mealRepo.save(meal);
    }

    public Meal updateMeal(MealDto mealDto, int id) {
        Meal meal = mealRepo.findById(id).get();
        meal.setName(mealDto.getName());
        meal.setPrice(mealDto.getPrice());
        Category category = categoryRepo.findById(mealDto.getCategory()).get();
        meal.setCategory(category);
        return mealRepo.save(meal);
    }

    public void deleteMeal(int id) {
        mealRepo.deleteById(id);
    }

}
