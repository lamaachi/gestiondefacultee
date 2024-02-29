package org.gstfac.gestionfactulte.Patterns.FactoryPattern;

import org.gstfac.gestionfactulte.modele.emuns.Fonctionnalite;
import org.gstfac.gestionfactulte.modele.entity.Batiment;
import org.gstfac.gestionfactulte.modele.entity.Salle;

public class SalleFactory implements Batimentfactory{
    @Override
    public Batiment createBatiment() {
        Salle salle = new Salle();
        salle.setFonctionnalite(Fonctionnalite.SALLE);
        return salle;
    }
}
