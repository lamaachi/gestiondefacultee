package org.gstfac.gestionfactulte.modele.Beans;

public class Departement {
    public int ID_Departement;
    public String Nom_Departement;

    // Constructors
    public Departement() {
    }

    public int getID_Departement() {
        return ID_Departement;
    }

    public void setID_Departement(int ID_Departement) {
        this.ID_Departement = ID_Departement;
    }

    public String getNom_Departement() {
        return Nom_Departement;
    }

    public void setNom_Departement(String nom_Departement) {
        Nom_Departement = nom_Departement;
    }
}
