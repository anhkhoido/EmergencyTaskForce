package com.anhkhoido.game.EmergencyTaskForce.controller;

import com.anhkhoido.game.EmergencyTaskForce.dao.caliber.CaliberRepository;
import com.anhkhoido.game.EmergencyTaskForce.model.firearm.Caliber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @GetMapping(path = "/findAll")
    public List<Caliber> findAll() {
        Iterable<Caliber> calibers = caliberRepository.findAll();
        return StreamSupport.stream(calibers.spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public Caliber findCaliberById(@PathVariable(value = "id") int id) {
        Integer i = Integer.valueOf(id);
        return caliberRepository.findById(i).get();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCaliber(@PathVariable(value = "id") int id) {
        if (caliberRepository.findById(id).isPresent()) {
            Caliber caliber = caliberRepository.findById(id).get();
            caliberRepository.delete(caliber);
        }
    }

    @DeleteMapping(path = "/deleteAll")
    public void deleteAll() {
        caliberRepository.deleteAll();
    }

}