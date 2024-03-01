package org.gstfac.gestionfactulte.modele.entity;
import org.gstfac.gestionfactulte.modele.emuns.Fonctionnalite;

public class Batiment {
    private int id;
    private String emplacement;
    private int taille;
    private Fonctionnalite fonctionnalite;
    private String description;

    // Getters
    public int getId() {
        return id;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public int getTaille() {
        return taille;
    }

    public Fonctionnalite getFonctionnalite() {
        return fonctionnalite;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public void setFonctionnalite(Fonctionnalite fonctionnalite) {
        this.fonctionnalite = fonctionnalite;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
