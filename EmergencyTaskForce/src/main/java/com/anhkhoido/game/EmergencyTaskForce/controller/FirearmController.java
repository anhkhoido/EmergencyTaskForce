package com.anhkhoido.game.EmergencyTaskForce.controller;

import com.anhkhoido.game.EmergencyTaskForce.dao.caliber.CaliberRepository;
import com.anhkhoido.game.EmergencyTaskForce.dao.firearm.FirearmRepository;
import com.anhkhoido.game.EmergencyTaskForce.model.firearm.Caliber;
import com.anhkhoido.game.EmergencyTaskForce.model.firearm.Firearm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/emergencyTaskForce/firearms")
public class FirearmController extends AbstractController {

    @Autowired
    private FirearmRepository firearmRepository;

    @Autowired
    private CaliberRepository caliberRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Firearm firearm) {
        Caliber caliber = new Caliber();
        if (firearm.getMagazine() == 10 && caliberRepository.findByName("9mm").isPresent()) {
            caliber = caliberRepository.findByName("9mm").get();
        } else if (firearm.getMagazine() == 8 && caliberRepository.findByName(".45 ACP").isPresent()) {
            caliber = caliberRepository.findByName(".45 ACP").get();
        } else if (firearm.getMagazine() == 30 && caliberRepository.findByName("5.56x45mm NATO").isPresent()) {
            caliber = caliberRepository.findByName("5.56x45mm NATO").get();
        }
        firearm.setCaliber(caliber);
        firearmRepository.save(firearm);
    }

    @Override
    public Firearm findById(@PathVariable(value = "id") int id) {
        return firearmRepository.findById(id).get();
    }

    @Override
    public void deleteById(@PathVariable(value = "id") int id) {
        if (firearmRepository.findById(id).isPresent()) {
            firearmRepository.deleteById(id);
        }
    }

    @Override
    public void deleteAll() {
        firearmRepository.deleteAll();
    }

    @Override
    public List<Firearm> findAll() {
        Iterable<Firearm> firearms = firearmRepository.findAll();
        return StreamSupport.stream(firearms.spliterator(), false).collect(Collectors.toList());
    }

}