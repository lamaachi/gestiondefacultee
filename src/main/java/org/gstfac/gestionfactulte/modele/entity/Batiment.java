package org.gstfac.gestionfactulte.modele.entity;
import org.gstfac.gestionfactulte.emuns.Fonctionnalite;

public interface Batiment {
    int getId();
    String getEmplacement();
    int getTaille();
    Fonctionnalite getFonctionnalite();

    void setFonctionnalite(Fonctionnalite fonctionnalite);

    String getDescription();

    void setId(int id);
    void setEmplacement(String emplacement);
    void setTaille(int taille);
    void setDescription(String description);
}
