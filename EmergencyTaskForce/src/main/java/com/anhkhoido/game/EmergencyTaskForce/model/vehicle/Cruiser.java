package com.anhkhoido.game.EmergencyTaskForce.model.vehicle;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Cruiser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column
    private String model;

    @Column
    private String manufacturer;

    @Column
    private int mileage;

    @Column
    private double currentFuel;

    @Column
    private double fuelCapacity;

    @Column
    private String builtInLaptop;

    @Column
    private int roomForFirearms;

    public Cruiser(String model, String manufacturer, int mileage, double currentFuel, double fuelCapacity, String builtInLaptop, int roomForFirearms) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.mileage = mileage;
        this.currentFuel = currentFuel;
        this.fuelCapacity = fuelCapacity;
        this.builtInLaptop = builtInLaptop;
        this.roomForFirearms = roomForFirearms;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cruiser cruiser = (Cruiser) o;
        return id == cruiser.id && mileage == cruiser.mileage && Double.compare(cruiser.currentFuel, currentFuel) == 0 && Double.compare(cruiser.fuelCapacity, fuelCapacity) == 0 && roomForFirearms == cruiser.roomForFirearms && Objects.equals(model, cruiser.model) && Objects.equals(manufacturer, cruiser.manufacturer) && Objects.equals(builtInLaptop, cruiser.builtInLaptop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, manufacturer, mileage, currentFuel, fuelCapacity, builtInLaptop, roomForFirearms);
    }
}