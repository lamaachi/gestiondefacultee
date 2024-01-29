package org.gstfac.gestionfactulte.Factory;

import org.gstfac.gestionfactulte.modele.entity.Doyen;
import org.gstfac.gestionfactulte.modele.entity.Personnel;

public class DoyenFactory implements PersonnelFactory{
    @Override
    public Personnel CreatePersonnel() {
        Personnel personnel = new Doyen();
        personnel.setFonction("doyen");
        return personnel;
    }
}
