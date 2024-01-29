package org.gstfac.gestionfactulte.Factory;

import org.gstfac.gestionfactulte.modele.entity.Personnel;
import org.gstfac.gestionfactulte.modele.entity.Administrateur;

public class AdministarteurFactory implements PersonnelFactory {
    @Override
    public Personnel CreatePersonnel() {
        Personnel personnel = new Administrateur();
        personnel.setFonction("administrateur");
        return personnel;
    }
}
