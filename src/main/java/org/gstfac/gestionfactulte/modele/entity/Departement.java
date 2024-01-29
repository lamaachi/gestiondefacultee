package org.gstfac.gestionfactulte.modele.entity;

import com.master.universite.composit.DepartmentComponent;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Departement implements DepartmentComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    @OneToMany(mappedBy = "departement")
    private List <Filiere> filieres;

    @OneToMany(mappedBy = "departement")
    private List <Enseignant> enseignants;


    public Departement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public List<Filiere> getFileres() {
        return filieres;
    }

    public void setFileres(List<Filiere> fileres) {
        this.filieres = fileres;
    }

    public List<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(List<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }

    @Override
    public String display() {
        return this.nom;
    }
}