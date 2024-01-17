package org.gstfac.gestionfactulte.Factory;

import org.gstfac.gestionfactulte.modele.Beans.Batiment;

public class ClasseFactory implements IBatimentFactory{
    @Override
    public Batiment createBatiment() {
        return new Batiment();
    }
}
