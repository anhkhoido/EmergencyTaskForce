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
public class CaliberController extends AbstractController {

    @Autowired
    private CaliberRepository caliberRepository;

    public CaliberController(CaliberRepository caliberRepository) {
        this.caliberRepository = caliberRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Caliber caliber) {
        caliberRepository.save(caliber);
    }

    @Override
    public Caliber findById(@PathVariable(value = "id") int id) {
        return caliberRepository.findById(id).get();
    }

    @Override
    public List<Caliber> findAll() {
        Iterable<Caliber> calibers = caliberRepository.findAll();
        return StreamSupport.stream(calibers.spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public void deleteById(@PathVariable(value = "id") int id) {
        if (caliberRepository.findById(id).isPresent()) {
            caliberRepository.deleteById(id);
        }
    }

    @Override
    public void deleteAll() {
        caliberRepository.deleteAll();
    }

}