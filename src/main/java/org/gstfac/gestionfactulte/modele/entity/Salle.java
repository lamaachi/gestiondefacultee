package org.gstfac.gestionfactulte.modele.entity;

import jakarta.persistence.*;
import org.gstfac.gestionfactulte.modele.emuns.Fonctionnalite;

@Entity
public class Salle implements Batiment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String emplacement;
    private int taille;
    @Enumerated(EnumType.STRING)
    private Fonctionnalite fonctionnalite;
    private String description;

    public Salle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public Fonctionnalite getFonctionnalite() {
        return fonctionnalite;
    }

    public void setFonctionnalite(Fonctionnalite fonctionnalite) {
        this.fonctionnalite = fonctionnalite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
