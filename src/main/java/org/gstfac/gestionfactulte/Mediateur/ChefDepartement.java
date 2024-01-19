package org.gstfac.gestionfactulte.Mediateur;

// Collègue
class ChefDepartement {
    private Mediateur mediateur;
    private String nom;

    public ChefDepartement(Mediateur mediateur, String nom) {
        this.mediateur = mediateur;
        this.nom = nom;
    }

    public void envoyerMessage(String message) {
        mediateur.informer(this, message);
    }

    public void recevoirMessage(String message) {
        System.out.println("Chef de département " + nom + " a reçu le message : " + message);
    }
}