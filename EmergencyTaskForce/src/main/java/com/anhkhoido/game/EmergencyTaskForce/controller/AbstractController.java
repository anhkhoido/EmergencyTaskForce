package com.anhkhoido.game.EmergencyTaskForce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public abstract class AbstractController<T> {

    @GetMapping(path = "/{id}")
    public abstract T findById(@PathVariable(value = "id") Integer id);

    @GetMapping(path = "/findAll")
    public abstract Iterable<T> findAll();

    @DeleteMapping(path = "/{id}")
    public abstract void deleteById(@PathVariable(value = "id") Integer id);

    @DeleteMapping(path = "/deleteAll")
    public abstract void deleteAll();

}