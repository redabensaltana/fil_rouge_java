package com.redabens.restosir.services;

import com.redabens.restosir.dto.ChefDto;
import com.redabens.restosir.entities.Chef;
import com.redabens.restosir.repositories.ChefRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChefService {
    @Autowired
    private ChefRepo chefRepo;

    public List<Chef> getAll() {
        return chefRepo.findAll();
    }

    public Chef getChefById(int id) {
        return chefRepo.findById(id).get();
    }

    public Chef saveChef(ChefDto chefDto) {
        Chef chef = new Chef();
        chef.setEmail(chefDto.getEmail());
        chef.setAddress(chefDto.getAddress());
        chef.setUsername(chefDto.getUsername());
        chef.setPassword(chefDto.getPassword());
        chef.setNumberPhone(chefDto.getNumberPhone());

        return chefRepo.save(chef);
    }

    public Chef updateChef(ChefDto chefDto, int id) {
        Chef chef = chefRepo.findById(id).get();
        chef.setEmail(chefDto.getEmail());
        chef.setAddress(chefDto.getAddress());
        chef.setUsername(chefDto.getUsername());
        chef.setPassword(chefDto.getPassword());
        chef.setNumberPhone(chefDto.getNumberPhone());
        return chefRepo.save(chef);
    }

    public void deleteChef(int id) {
        chefRepo.deleteById(id);
    }

}
