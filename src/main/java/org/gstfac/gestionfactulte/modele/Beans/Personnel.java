package org.gstfac.gestionfactulte.modele.Beans;

public class Personnel {
    public int ID_Personnel;
    public String nom;
    public String prenom;
    public String fonction;
    public String identifiant;
    public String email;
    public String password;

    // Constructors
    public Personnel() {
    }

    public int getID_Personnel() {
        return ID_Personnel;
    }

    public void setID_Personnel(int ID_Personnel) {
        this.ID_Personnel = ID_Personnel;
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

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
