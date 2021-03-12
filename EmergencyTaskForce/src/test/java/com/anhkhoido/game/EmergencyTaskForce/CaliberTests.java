package com.anhkhoido.game.EmergencyTaskForce;

import com.anhkhoido.game.EmergencyTaskForce.dao.caliber.CaliberRepository;
import com.anhkhoido.game.EmergencyTaskForce.model.firearm.Caliber;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CaliberTests {

    @Autowired
    private CaliberRepository caliberRepository;

    @Test
    @Rollback(false)
    public void testCreate() throws Exception {
        Caliber caliber = new Caliber(9.0, 19.0, "9mm");
        long bla = caliberRepository.count();
        Assert.assertTrue(bla == 0);
    }
}