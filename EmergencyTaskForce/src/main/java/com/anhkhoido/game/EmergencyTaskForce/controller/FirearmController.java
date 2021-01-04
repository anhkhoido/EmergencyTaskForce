package com.anhkhoido.game.EmergencyTaskForce.controller;

import com.anhkhoido.game.EmergencyTaskForce.dao.firearm.FirearmRepository;
import com.anhkhoido.game.EmergencyTaskForce.model.firearm.Firearm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/emergencyTaskForce/firearms")
public class FirearmController extends AbstractController {

    private FirearmRepository firearmRepository;

    @Autowired
    public FirearmController(FirearmRepository firearmRepository) {
        this.firearmRepository = firearmRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Firearm firearm) {
        firearmRepository.save(firearm);
    }

    @Override
    public Firearm findById(@PathVariable(value = "id") Integer id) {
        return firearmRepository.findById(id).get();
    }

    @Override
    public void deleteById(@PathVariable(value = "id") Integer id) {
        if (firearmRepository.findById(id).isPresent()) {
            firearmRepository.deleteById(id);
        }
    }

    @Override
    public void deleteAll() {
        firearmRepository.deleteAll();
    }

    @Override
    public Iterable<Firearm> findAll() {
        return firearmRepository.findAll();
    }

}