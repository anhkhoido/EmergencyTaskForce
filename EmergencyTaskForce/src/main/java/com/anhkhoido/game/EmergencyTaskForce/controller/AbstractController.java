package com.anhkhoido.game.EmergencyTaskForce.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class AbstractController<T> {

    private final String URL_PATH_ID = "/{id}";

    @GetMapping(path = URL_PATH_ID)
    public abstract T findById(@PathVariable(value = "id") Integer id);

    @GetMapping(path = "/findAll")
    public abstract Iterable<T> findAll();

    @DeleteMapping(path = URL_PATH_ID)
    public abstract void deleteById(@PathVariable(value = "id") Integer id);

    @DeleteMapping(path = "/deleteAll")
    public abstract void deleteAll();

}