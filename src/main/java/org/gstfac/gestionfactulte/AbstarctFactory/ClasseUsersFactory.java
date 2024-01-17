package org.gstfac.gestionfactulte.AbstarctFactory;

import org.gstfac.gestionfactulte.modele.Beans.Etudiant;
import org.gstfac.gestionfactulte.modele.Beans.Personnel;

public class ClasseUsersFactory implements IUtilisateurFactory {
    @Override
    public Etudiant createEtudiant() {
        return new Etudiant();
    }

    @Override
    public Personnel createEnseignent() {
        Personnel Enseignant = new Personnel();
        Enseignant.setFonction("Enseignant");
        return Enseignant;
    }

    @Override
    public Personnel createDoyen() {
        Personnel Doyen = new Personnel();
        Doyen.setFonction("Doyen");
        return Doyen;
    }

    @Override
    public Personnel createAdministrateur() {
        Personnel Administraeur = new Personnel();
        Administraeur.setFonction("Administraeur");
        return Administraeur;
    }
}
