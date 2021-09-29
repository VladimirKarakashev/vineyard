package com.vtk.vineyard.model;

import javax.persistence.*;

@Entity
public class Phenophase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PHENO_ID")
    private long id;
    private String name;
    private String description;
    private String practices;
    @ManyToOne
    @JoinColumn(name = "culture_id")
    private Culture culture;

    public Phenophase() {
    }

    public Phenophase(long id, String name, String description, String practices, Culture culture) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.practices = practices;
        this.culture = culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
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

    public String getPractices() {
        return practices;
    }

    public void setPractices(String practices) {
        this.practices = practices;
    }
}
