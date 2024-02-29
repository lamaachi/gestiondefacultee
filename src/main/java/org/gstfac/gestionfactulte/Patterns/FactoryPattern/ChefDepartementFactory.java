package org.gstfac.gestionfactulte.Patterns.FactoryPattern;

import org.gstfac.gestionfactulte.modele.entity.Personnel;
import org.gstfac.gestionfactulte.modele.entity.ChefDepartement;

public class ChefDepartementFactory implements PersonnelFactory{
    @Override
    public Personnel CreatePersonnel() {
        Personnel personnel = new ChefDepartement();
        personnel.setFonction("chefdepartement");
        return personnel;
    }
}
