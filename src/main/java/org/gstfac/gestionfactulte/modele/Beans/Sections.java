package org.gstfac.gestionfactulte.modele.Beans;

public class Sections {
    private int ID_Section;
    private String Nom_Section;

    // Constructors
    public Sections() {
    }

    public int getID_Section() {
        return ID_Section;
    }

    public void setID_Section(int ID_Section) {
        this.ID_Section = ID_Section;
    }

    public String getNom_Section() {
        return Nom_Section;
    }

    public void setNom_Section(String nom_Section) {
        Nom_Section = nom_Section;
    }
}
