package org.gstfac.gestionfactulte.modele.entity;

import jakarta.persistence.*;


@Entity
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String code;
    private String situationScolaire;
    @ManyToOne
    private Section section;
    public Etudiant() {

    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSituationScolaire() {
        return situationScolaire;
    }

    public void setSituationScolaire(String situationScolaire) {
        this.situationScolaire = situationScolaire;
    }
}
