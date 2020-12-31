package com.anhkhoido.game.EmergencyTaskForce.controller;

import com.anhkhoido.game.EmergencyTaskForce.model.firearm.Caliber;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public abstract class AbstractController {

    @GetMapping(path = "/{id}")
    public abstract Object findById(@PathVariable(value = "id") int id);

    @GetMapping(path = "/findAll")
    public abstract List<? extends Object> findAll();

    @DeleteMapping(path = "/{id}")
    public abstract void deleteById(@PathVariable(value = "id") int id);

    @DeleteMapping(path = "/deleteAll")
    public abstract void deleteAll();

}