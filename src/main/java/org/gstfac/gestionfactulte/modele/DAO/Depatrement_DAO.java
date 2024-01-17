package org.gstfac.gestionfactulte.modele.DAO;

import org.gstfac.gestionfactulte.modele.Beans.Departement;
import org.gstfac.gestionfactulte.modele.Beans.Etudiant;

import java.util.ArrayList;

public interface Depatrement_DAO {
    ArrayList<Departement> findAll();
    Departement findByID(int ID_Departement);
    void insert(Departement departement);
    void update(Departement departement);
    void deleteByID(int ID_Departement);
}
