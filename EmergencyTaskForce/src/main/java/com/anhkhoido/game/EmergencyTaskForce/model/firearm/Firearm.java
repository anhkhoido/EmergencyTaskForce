package com.anhkhoido.game.EmergencyTaskForce.model.firearm;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Firearm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column
    private String name;

    @Column
    private String manufacturer;

    @Column
    private int magazine;

    @OneToOne
    @JoinColumn(name = "fk_caliber", referencedColumnName = "id")
    private Caliber caliber;

    public Firearm() {
        super();
    }

    public Firearm(String name, String manufacturer, int magazine, Caliber caliber) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.magazine = magazine;
        this.caliber = caliber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getMagazine() {
        return magazine;
    }

    public void setMagazine(int magazine) {
        this.magazine = magazine;
    }

    public void setCaliber(Caliber caliber) {
        this.caliber = caliber;
    }

    public Caliber getCaliber() {
        return caliber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Firearm firearm = (Firearm) o;
        return id == firearm.id &&
                magazine == firearm.magazine &&
                name.equals(firearm.name) &&
                manufacturer.equals(firearm.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, manufacturer, magazine);
    }

    @Override
    public String toString() {
        return "Firearm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", magazine=" + magazine +
                '}';
    }
}
