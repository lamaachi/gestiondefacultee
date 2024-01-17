package org.gstfac.gestionfactulte.Factory;

import org.gstfac.gestionfactulte.modele.Beans.Batiment;
import org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation.Batiment_DAO_JDBC;

public interface IBatimentFactory {
    Batiment createBatiment();
}
