package org.gstfac.gestionfactulte.AbstarctFactory;

import org.gstfac.gestionfactulte.modele.Beans.Etudiant;
import org.gstfac.gestionfactulte.modele.Beans.Personnel;

public interface IUtilisateurFactory {
    Etudiant createEtudiant();
    Personnel createEnseignent();
    Personnel createDoyen();
    Personnel createAdministrateur();
}
