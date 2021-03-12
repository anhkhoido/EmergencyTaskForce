package com.anhkhoido.game.EmergencyTaskForce.model.firearm;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Caliber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column
    private double length;

    @Column
    private double width;

    @Column
    private String name;

    public Caliber() {}

    public Caliber(double length, double width, String name) {
        this.length = length;
        this.width = width;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caliber caliber = (Caliber) o;
        return id == caliber.id &&
                Double.compare(caliber.length, length) == 0 &&
                Double.compare(caliber.width, width) == 0 &&
                name.equals(caliber.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, length, width, name);
    }

    @Override
    public String toString() {
        return "Caliber{" +
                "id=" + id +
                ", length=" + length +
                ", width=" + width +
                ", name='" + name + '\'' +
                '}';
    }
}