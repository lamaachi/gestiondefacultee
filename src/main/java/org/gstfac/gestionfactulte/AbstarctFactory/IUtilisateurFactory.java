package org.gstfac.gestionfactulte.AbstarctFactory;

import org.gstfac.gestionfactulte.modele.entity.Etudiant;
import org.gstfac.gestionfactulte.modele.entity.Personnel;

public interface IUtilisateurFactory {
    Etudiant createEtudiant();
    Personnel createEnseignent();
    Personnel createDoyen();
    Personnel createAdministrateur();
}
