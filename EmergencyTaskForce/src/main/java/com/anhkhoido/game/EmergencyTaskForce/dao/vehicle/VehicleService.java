package com.anhkhoido.game.EmergencyTaskForce.dao.vehicle;

import com.anhkhoido.game.EmergencyTaskForce.model.vehicle.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService implements VehicleRepository {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.findById(vehicle.getId()).orElse(vehicleRepository.save(vehicle));
    }

    @Override
    public <S extends Vehicle> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Vehicle> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer id) {
        return vehicleRepository.existsById(id);
    }

    @Override
    public Iterable<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Iterable<Vehicle> findAllById(Iterable<Integer> iterable) {
        return vehicleRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return vehicleRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        if (vehicleRepository.findById(id).isPresent()) {
            vehicleRepository.deleteById(id);
        }
    }

    @Override
    public void delete(Vehicle vehicle) {
        if (vehicleRepository.findById(vehicle.getId()).isPresent()) {
            vehicleRepository.delete(vehicle);
        }
    }

    @Override
    public void deleteAll(Iterable<? extends Vehicle> iterable) {
        vehicleRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        vehicleRepository.deleteAll();
    }
}
