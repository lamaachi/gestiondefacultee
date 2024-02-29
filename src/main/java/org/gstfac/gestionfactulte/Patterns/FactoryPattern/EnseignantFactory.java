package org.gstfac.gestionfactulte.Patterns.FactoryPattern;

import org.gstfac.gestionfactulte.modele.entity.Enseignant;
import org.gstfac.gestionfactulte.modele.entity.Personnel;

public class EnseignantFactory implements  PersonnelFactory{
    @Override
    public Personnel CreatePersonnel() {
        Personnel personnel = new Enseignant();
        personnel.setFonction("enseignant");
        return personnel;
    }
}
