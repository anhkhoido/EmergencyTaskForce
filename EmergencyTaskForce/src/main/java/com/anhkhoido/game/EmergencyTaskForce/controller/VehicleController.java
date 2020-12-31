package com.anhkhoido.game.EmergencyTaskForce.controller;

import com.anhkhoido.game.EmergencyTaskForce.dao.vehicle.VehicleRepository;
import com.anhkhoido.game.EmergencyTaskForce.model.vehicle.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/emergencyTaskForce/vehicles")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping(path = "/findAll")
    public List<Vehicle> findAll() {
        Iterable<Vehicle> vehicles = vehicleRepository.findAll();
        return StreamSupport.stream(vehicles.spliterator(), false).collect(Collectors.toList());
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable(value = "id") int id) {
        if (vehicleRepository.findById(id).isPresent()) {
            vehicleRepository.deleteById(id);
        }
    }

    @DeleteMapping(path = "/deleteAll")
    public void deleteAll() {
        vehicleRepository.deleteAll();
    }

}
