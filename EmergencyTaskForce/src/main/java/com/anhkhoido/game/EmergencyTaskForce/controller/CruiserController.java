package com.anhkhoido.game.EmergencyTaskForce.controller;

import com.anhkhoido.game.EmergencyTaskForce.dao.vehicle.cruiser.CruiserRepository;
import com.anhkhoido.game.EmergencyTaskForce.model.vehicle.Cruiser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/emergencyTaskForce/cruisers")
public class CruiserController extends AbstractController {

    private CruiserRepository cruiserRepository;

    @Autowired
    public CruiserController(CruiserRepository cruiserRepository) {
        this.cruiserRepository = cruiserRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Cruiser cruiser) {
        cruiserRepository.save(cruiser);
    }

    @Override
    public Cruiser findById(@PathVariable(value = "id") Integer id) {
        return cruiserRepository.findById(id).get();
    }

    @Override
    public Iterable<Cruiser> findAll() {
        return cruiserRepository.findAll();
    }

    @Override
    public void deleteById(@PathVariable(value = "id") Integer id) {
        cruiserRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        cruiserRepository.deleteAll();
    }
}
