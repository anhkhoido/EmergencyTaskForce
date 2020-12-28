package com.anhkhoido.game.EmergencyTaskForce;

import com.anhkhoido.game.EmergencyTaskForce.dao.caliber.CaliberService;
import com.anhkhoido.game.EmergencyTaskForce.dao.firearm.FirearmService;
import com.anhkhoido.game.EmergencyTaskForce.model.firearm.Caliber;
import com.anhkhoido.game.EmergencyTaskForce.model.firearm.Firearm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EmergencyTaskForceApplication implements CommandLineRunner {

    @Autowired
    private FirearmService firearmService;

    @Autowired
    private CaliberService caliberService;

	public static void main(String[] args) {
		SpringApplication.run(EmergencyTaskForceApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        createCalibers();
	    createFirearms();
    }

    private void createCalibers() {
        List<Caliber> caliberList = new ArrayList<>();
        caliberList.add(new Caliber(9.0, 19.0, "9mm"));
        caliberList.add(new Caliber(11.43, 23.0, ".45 ACP"));
        caliberList.add(new Caliber(5.56, 45.0, "5.56x45mm NATO"));
        caliberList.forEach(caliber -> caliberService.save(caliber));
    }

    private void createFirearms() {
        List<Firearm> firearmList = new ArrayList<>();
        firearmList.add(new Firearm("Shadow 2 Black", "CZ", 10, caliberService.findByName("9mm").get()));
        firearmList.add(new Firearm("1911 R1", "Remington", 8, caliberService.findByName(".45 ACP").get()));
        firearmList.forEach(firearm -> firearmService.save(firearm));
    }

}