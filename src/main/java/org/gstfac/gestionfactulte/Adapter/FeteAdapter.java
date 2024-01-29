package org.gstfac.gestionfactulte.Adapter;

import org.gstfac.gestionfactulte.emuns.Fonctionnalite;
import org.gstfac.gestionfactulte.modele.entity.Batiment;
import org.gstfac.gestionfactulte.modele.entity.Salle;

public class FeteAdapter implements Batiment {
    Salle salle;

    public FeteAdapter(Salle salle) {
        this.salle = salle;
    }

    @Override
    public int getId() {
        return salle.getId();
    }

    @Override
    public void setId(int id) {
        salle.setId(id);
    }

    @Override
    public String getEmplacement() {
        return salle.getEmplacement();
    }

    @Override
    public void setEmplacement(String emplacement) {
        salle.setEmplacement(emplacement);
    }

    @Override
    public int getTaille() {
        return salle.getTaille();
    }

    @Override
    public void setTaille(int taille) {
        salle.setTaille(taille);
    }

    @Override
    public Fonctionnalite getFonctionnalite() {
        return Fonctionnalite.SALLE_DE_FETE;
    }

    @Override
    public void setFonctionnalite(Fonctionnalite fonctionnalite) {
        salle.setFonctionnalite(fonctionnalite);
    }

    @Override
    public String getDescription() {
        return salle.getDescription();
    }

    @Override
    public void setDescription(String description) {
        salle.setDescription(description);
    }

    @Override
    public String toString() {
        return "FeteAdapter{" +
                "id=" + salle.getId() +
                ", emplacement='" + salle.getEmplacement() + '\'' +
                ", taille=" + salle.getTaille() +
                ", fonctionnalite=" + getFonctionnalite() +
                ", description='" + salle.getDescription() + '\'' +
                '}';
    }

}
