package org.gstfac.gestionfactulte.Factory;

import org.gstfac.gestionfactulte.emuns.Fonctionnalite;
import org.gstfac.gestionfactulte.modele.entity.Amphi;
import org.gstfac.gestionfactulte.modele.entity.Batiment;

public class AmphiFactory implements  Batimentfactory {
    @Override
    public Batiment createBatiment() {
        Amphi amphi = new Amphi();
        amphi.setFonctionnalite(Fonctionnalite.AMPHI);
        return amphi;
    }
}
