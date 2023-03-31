package com.redabens.restosir.services;

import com.redabens.restosir.dto.ZoneDto;
import com.redabens.restosir.entities.Zone;
import com.redabens.restosir.repositories.ZoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService {
    @Autowired
    private ZoneRepo zoneRepo;

    public List<Zone> getAll() {
        return zoneRepo.findAll();
    }

    public Zone getZoneById(int id) {
        return zoneRepo.findById(id).get();
    }

    public Zone saveZone(ZoneDto zoneDto) {
        Zone zone = new Zone();
        zone.setName(zoneDto.getName());
        zone.setStatus(zoneDto.getStatus());

        return zoneRepo.save(zone);
    }

    public Zone updateZone(ZoneDto zoneDto, int id) {
        Zone zone = zoneRepo.findById(id).get();
        zone.setName(zoneDto.getName());
        zone.setStatus(zoneDto.getStatus());
        return zoneRepo.save(zone);
    }

    public void deleteZone(int id) {
        zoneRepo.deleteById(id);
    }

}

