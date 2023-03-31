package com.redabens.restosir.services;

import com.redabens.restosir.dto.SeatDto;
import com.redabens.restosir.entities.Seat;
import com.redabens.restosir.entities.Zone;
import com.redabens.restosir.repositories.SeatRepo;
import com.redabens.restosir.repositories.ZoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    @Autowired
    private SeatRepo seatRepo;
    @Autowired
    private ZoneRepo zoneRepo;

    public List<Seat> getAll() {
        return seatRepo.findAll();
    }

    public List<Seat> getAllWhere(Integer zone) {
        //update to entity
        return seatRepo.findByZone(zone);
    }

    public Seat getSeatById(int id) {
        return seatRepo.findById(id).get();
    }

    public Seat saveSeat(SeatDto seatDto) {
        Seat seat = new Seat();
        seat.setStatus(seatDto.getStatus());
        Zone zone = zoneRepo.findById(seatDto.getZone()).get();
        seat.setZone(zone);

        return seatRepo.save(seat);
    }

    public Seat updateSeat(SeatDto seatDto, int id) {
        Seat seat = seatRepo.findById(id).get();
        seat.setStatus(seatDto.getStatus());
        Zone zone = zoneRepo.findById(seatDto.getZone()).get();
        seat.setZone(zone);
        return seatRepo.save(seat);
    }

    public void deleteSeat(int id) {
        seatRepo.deleteById(id);
    }

}
