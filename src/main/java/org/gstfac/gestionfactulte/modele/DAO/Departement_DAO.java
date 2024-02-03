package org.gstfac.gestionfactulte.modele.DAO;

import org.gstfac.gestionfactulte.modele.entity.Departement;

import java.util.ArrayList;

public interface Departement_DAO {
    ArrayList<Departement> findAll();
    Departement findByID(int id);
    void insert(Departement departement);
    void update(Departement departement);
    void deleteByID(int id);
}
