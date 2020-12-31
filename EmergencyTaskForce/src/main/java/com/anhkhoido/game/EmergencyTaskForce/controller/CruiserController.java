package com.anhkhoido.game.EmergencyTaskForce.controller;

import com.anhkhoido.game.EmergencyTaskForce.dao.vehicle.cruiser.CruiserRepository;
import com.anhkhoido.game.EmergencyTaskForce.model.vehicle.Cruiser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/emergencyTaskForce/cruisers")
public class CruiserController extends AbstractController {

    @Autowired
    private CruiserRepository cruiserRepository;

    @Override
    public Cruiser findById(@PathVariable(value = "id") int id) {
        return cruiserRepository.findById(id).get();
    }

    @Override
    public List<Cruiser> findAll() {
        Iterable<Cruiser> cruisers = cruiserRepository.findAll();
        return StreamSupport.stream(cruisers.spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public void deleteById(@PathVariable(value = "id") int id) {
        cruiserRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        cruiserRepository.deleteAll();
    }
}
