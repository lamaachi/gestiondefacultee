package org.gstfac.gestionfactulte.Patterns.AdapterPattern;

import org.gstfac.gestionfactulte.modele.emuns.Fonctionnalite;
import org.gstfac.gestionfactulte.modele.entity.Amphi;
import org.gstfac.gestionfactulte.modele.entity.Batiment;

public class Soutenance_Adapter implements Batiment {
    Amphi amphi;

    public Soutenance_Adapter(Amphi amphi) {
        this.amphi = amphi;
    }

    @Override
    public int getId() {
        return amphi.getId();
    }

    @Override
    public void setId(int id) {
        amphi.setId(id);
    }

    @Override
    public String getEmplacement() {
        return amphi.getEmplacement();
    }

    @Override
    public void setEmplacement(String emplacement) {
        amphi.setEmplacement(emplacement);
    }

    @Override
    public int getTaille() {
        return amphi.getTaille();
    }

    @Override
    public void setTaille(int taille) {
        amphi.setTaille(taille);
    }

    @Override
    public Fonctionnalite getFonctionnalite() {
        return Fonctionnalite.SALLE_DE_SOUTENANCE;
    }

    @Override
    public void setFonctionnalite(Fonctionnalite fonctionnalite) {
        amphi.setFonctionnalite(fonctionnalite);
    }

    @Override
    public  String getDescription() {
        return amphi.getDescription();
    }

    @Override
    public void setDescription(String description) {
        amphi.setDescription(description);
    }

    @Override
    public String toString() {
        return "SoutenanceAdapter{" +
                "id=" + amphi.getId() +
                ", emplacement='" + amphi.getEmplacement() + '\'' +
                ", taille=" + amphi.getTaille() +
                ", fonctionnalite=" + getFonctionnalite() +
                ", description='" + amphi.getDescription() + '\'' +
                '}';
    }
}
