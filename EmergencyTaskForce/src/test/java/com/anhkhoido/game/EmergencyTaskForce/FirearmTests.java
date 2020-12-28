package com.anhkhoido.game.EmergencyTaskForce;

import com.anhkhoido.game.EmergencyTaskForce.dao.firearm.FirearmRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FirearmTests {

    @Autowired
    private FirearmRepository firearmRepository;

    @Test
    void findFirearmByManufacturer_test() {

    }

    @Test
    void findFirearmByName_test() {

    }

    @Test
    void createFirearm_test() {

    }

    @Test
    void deleteFirearm_test() {

    }

}