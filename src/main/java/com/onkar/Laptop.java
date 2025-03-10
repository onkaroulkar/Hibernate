package com.onkar;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Laptop {

    @Id
    private int id;
    private String modelName;
    private int ram;
    private String colour;
    @ManyToMany(mappedBy = "laptop")
    private List<Alien> alien;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Alien> getAlien() {
        return alien;
    }

    public void setAlien(List<Alien> alien) {
        this.alien = alien;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", ram=" + ram +
                ", colour='" + colour + '\'' +
                ", alien=" + alien +
                '}';
    }
}
