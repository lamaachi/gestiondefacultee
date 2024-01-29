package org.gstfac.gestionfactulte.modele.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Enseignant extends Personnel {
    @ManyToOne
    Departement departement;
    @Column(insertable = false, updatable = false)
    private String fonction;
    @ManyToMany
    private List<Section> sections;

    public Enseignant() {
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }


    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}