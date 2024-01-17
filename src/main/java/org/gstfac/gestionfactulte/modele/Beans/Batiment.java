package org.gstfac.gestionfactulte.modele.Beans;

public class Batiment {
    public int ID_Batiment;
    public String emplacement;
    public int taille;
    public String fonctionnalite;  //classe-
    public String description;
    // Constructors
    public Batiment() {
    }
    public int getID_Batiment() {
        return ID_Batiment;
    }

    public void setID_Batiment(int ID_Batiment) {
        this.ID_Batiment = ID_Batiment;
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

    public String getFonctionnalite() {
        return fonctionnalite;
    }

    public void setFonctionnalite(String fonctionnalite) {
        this.fonctionnalite = fonctionnalite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
