package com.vtk.vineyard.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Culture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CULTURE_ID")
    private long id;
    private String name;
    private String description;
    private String basics;
    @OneToMany(
            mappedBy = "culture",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Phenophase> phenophases = new ArrayList<>();
    @OneToMany(
            mappedBy = "culture",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Operation> operations = new ArrayList<>();

    public Culture(long id, String name, String description, String basics) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.basics = basics;
    }

    public void setPhenophases(List<Phenophase> phenophases) {
        this.phenophases = phenophases;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public Culture() {
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBasics() {
        return basics;
    }

    public void setBasics(String basics) {
        this.basics = basics;
    }
}
