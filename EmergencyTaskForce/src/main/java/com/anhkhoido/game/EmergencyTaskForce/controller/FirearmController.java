package com.anhkhoido.game.EmergencyTaskForce.controller;

import com.anhkhoido.game.EmergencyTaskForce.dao.firearm.FirearmRepository;
import com.anhkhoido.game.EmergencyTaskForce.model.firearm.Firearm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/emergencyTaskForce/firearms")
public class FirearmController {

    @Autowired
    private FirearmRepository firearmRepository;

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Firearm findFirearmById(@PathVariable(value = "id") int id) {
        return firearmRepository.findById(id).get();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteFirearm(@PathVariable(value = "id") int id) {
        Firearm firearm = firearmRepository.findById(id).get();
        firearmRepository.delete(firearm);
    }

}