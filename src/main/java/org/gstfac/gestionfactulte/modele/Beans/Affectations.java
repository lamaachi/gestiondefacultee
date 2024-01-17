package org.gstfac.gestionfactulte.modele.Beans;

public class Affectations {
    public int ID_Affectation;
    public Sections section;
    public Etudiant etudiant;

    // Constructors
    public Affectations() {

    }
    public int getID_Affectation() {
        return ID_Affectation;
    }

    public void setID_Affectation(int ID_Affectation) {
        this.ID_Affectation = ID_Affectation;
    }

    public Sections getSection() {
        return section;
    }

    public void setSection(Sections section) {
        this.section = section;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}
