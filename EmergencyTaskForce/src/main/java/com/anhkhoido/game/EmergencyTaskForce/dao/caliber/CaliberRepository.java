package com.anhkhoido.game.EmergencyTaskForce.dao.caliber;

import com.anhkhoido.game.EmergencyTaskForce.model.firearm.Caliber;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CaliberRepository extends CrudRepository<Caliber, Integer> {
    Optional<Caliber> findByName(String name);
}
