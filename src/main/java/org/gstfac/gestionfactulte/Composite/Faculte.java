package org.gstfac.gestionfactulte.Composite;

import java.util.ArrayList;
import java.util.List;
// Composite
class Faculte implements Element {
    private String nom;
    private List<Element> departements = new ArrayList<>();

    public Faculte(String nom) {
        this.nom = nom;
    }

    public void ajouterDepartement(Element departement) {
        departements.add(departement);
    }

    @Override
    public void afficher() {
        System.out.println("Faculté : " + nom);
        System.out.println("Liste des départements :");

        for (Element departement : departements) {
            departement.afficher();
        }
    }
}