package com.anhkhoido.game.EmergencyTaskForce.model.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Cruiser extends Vehicle {

    @Column
    private String builtInLaptop;

    @Column
    private int roomForFirearms;

    public Cruiser() {}

    public Cruiser(String builtInLaptop, int roomForFirearms) {
        this.builtInLaptop = builtInLaptop;
        this.roomForFirearms = roomForFirearms;
    }

    public String getBuiltInLaptop() {
        return builtInLaptop;
    }

    public void setBuiltInLaptop(String builtInLaptop) {
        this.builtInLaptop = builtInLaptop;
    }

    public int getRoomForFirearms() {
        return roomForFirearms;
    }

    public void setRoomForFirearms(int roomForFirearms) {
        this.roomForFirearms = roomForFirearms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cruiser cruiser = (Cruiser) o;
        return roomForFirearms == cruiser.roomForFirearms &&
                Objects.equals(builtInLaptop, cruiser.builtInLaptop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(builtInLaptop, roomForFirearms);
    }

    @Override
    public String toString() {
        return "Cruiser{" +
                "builtInLaptop='" + builtInLaptop + '\'' +
                ", roomForFirearms=" + roomForFirearms +
                '}';
    }
}