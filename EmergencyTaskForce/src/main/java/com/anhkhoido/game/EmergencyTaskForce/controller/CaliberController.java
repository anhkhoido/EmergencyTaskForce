package com.anhkhoido.game.EmergencyTaskForce.controller;

import com.anhkhoido.game.EmergencyTaskForce.dao.caliber.CaliberRepository;
import com.anhkhoido.game.EmergencyTaskForce.model.firearm.Caliber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/emergencyTaskForce/calibers")
public class CaliberController {

    @Autowired
    private CaliberRepository caliberRepository;

    public CaliberController(CaliberRepository caliberRepository) {
        this.caliberRepository = caliberRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCaliber(@RequestBody Caliber caliber) {
        caliberRepository.save(caliber);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Caliber findCaliberById(@PathVariable(value = "id") int id) {
        Integer i = Integer.valueOf(id);
        return caliberRepository.findById(i).get();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCaliber(@PathVariable(value = "id") int id) {
        Caliber caliber = caliberRepository.findById(id).get();
        caliberRepository.delete(caliber);
    }

}