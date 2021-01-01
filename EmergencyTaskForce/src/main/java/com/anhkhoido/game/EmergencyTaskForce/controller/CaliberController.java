package com.anhkhoido.game.EmergencyTaskForce.controller;

import com.anhkhoido.game.EmergencyTaskForce.dao.caliber.CaliberRepository;
import com.anhkhoido.game.EmergencyTaskForce.model.firearm.Caliber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/emergencyTaskForce/calibers")
public class CaliberController extends AbstractController {

    private CaliberRepository caliberRepository;

    @Autowired
    public CaliberController(CaliberRepository caliberRepository) {
        this.caliberRepository = caliberRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Caliber caliber) {
        caliberRepository.save(caliber);
    }

    @Override
    public Caliber findById(@PathVariable(value = "id") Integer id) {
        return caliberRepository.findById(id).get();
    }

    @Override
    public Iterable<Caliber> findAll() {
        return caliberRepository.findAll();
    }

    @Override
    public void deleteById(@PathVariable(value = "id") Integer id) {
        if (caliberRepository.findById(id).isPresent()) {
            caliberRepository.deleteById(id);
        }
    }

    @Override
    public void deleteAll() {
        caliberRepository.deleteAll();
    }

}