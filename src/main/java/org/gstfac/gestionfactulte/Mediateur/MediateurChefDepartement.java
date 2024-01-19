package org.gstfac.gestionfactulte.Mediateur;

import java.util.ArrayList;
import java.util.List;

// Concret Médiateur
class MediateurChefDepartement implements Mediateur {
    private List<ChefDepartement> chefsDepartement = new ArrayList<>();

    public void ajouterChefDepartement(ChefDepartement chefDepartement) {
        chefsDepartement.add(chefDepartement);
    }

    @Override
    public void informer(ChefDepartement emetteur, String message) {
        for (ChefDepartement chefDepartement : chefsDepartement) {
            if (chefDepartement != emetteur) {
                chefDepartement.recevoirMessage(message);
            }
        }
    }
}