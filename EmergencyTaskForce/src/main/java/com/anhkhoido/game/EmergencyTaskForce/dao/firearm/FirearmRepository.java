package com.anhkhoido.game.EmergencyTaskForce.dao.firearm;

import com.anhkhoido.game.EmergencyTaskForce.model.firearm.Firearm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Optional;

public interface FirearmRepository extends CrudRepository<Firearm, Integer> {

    @Override
    @RestResource(exported = false)
    void delete(Firearm firearm);

    @Override
    @RestResource(exported = false)
    void deleteAll();

    Optional<Firearm> findByName(String name);
    List<Firearm> findByManufacturer(String manufacturer);

}
