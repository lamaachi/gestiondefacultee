package org.gstfac.gestionfactulte.Composite;

// Feuille
class Departement implements Element {
    private String nom;

    public Departement(String nom) {
        this.nom = nom;
    }

    @Override
    public void afficher() {
        System.out.println("Département : " + nom);
    }
}