package com.vtk.vineyard.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OP_ID")
    private long id;
    private LocalDate date = java.time.LocalDate.now();
    private String name;
    private float cost;
    private int duration;
    @ManyToOne
    @JoinColumn(name = "culture_id")
    private Culture culture;

    public Operation() {
    }

    public Operation(long id, LocalDate date, String name, float cost, int duration, Culture culture) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.cost = cost;
        this.duration = duration;
        this.culture = culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public Culture getCulture() {
        return culture;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {

        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
