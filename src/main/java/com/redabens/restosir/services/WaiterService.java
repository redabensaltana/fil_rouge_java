package com.redabens.restosir.services;

import com.redabens.restosir.dto.WaiterDto;
import com.redabens.restosir.entities.Waiter;
import com.redabens.restosir.repositories.WaiterRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaiterService {
    @Autowired
    private WaiterRepo waiterRepo;

    public List<Waiter> getAll() {
        return waiterRepo.findAll();
    }

    public Waiter getWaiterById(int id) {
        return waiterRepo.findById(id).get();
    }

    public Waiter saveWaiter(WaiterDto waiterDto) {
        Waiter waiter = new Waiter();
//        BeanUtils.copyProperties(waiterDto, waiter);
        waiter.setEmail(waiterDto.getEmail());
        waiter.setAddress(waiterDto.getAddress());
        waiter.setUsername(waiterDto.getUsername());
        waiter.setPassword(waiterDto.getPassword());
        waiter.setNumberPhone(waiterDto.getNumberPhone());

        return waiterRepo.save(waiter);
    }

    public Waiter updateWaiter(WaiterDto waiterDto, int id) {
        Waiter waiter = waiterRepo.findById(id).get();
        waiter.setEmail(waiterDto.getEmail());
        waiter.setAddress(waiterDto.getAddress());
        waiter.setUsername(waiterDto.getUsername());
        waiter.setPassword(waiterDto.getPassword());
        waiter.setNumberPhone(waiterDto.getNumberPhone());
        return waiterRepo.save(waiter);
    }

    public void deleteWaiter(int id) {
        waiterRepo.deleteById(id);
    }

}

