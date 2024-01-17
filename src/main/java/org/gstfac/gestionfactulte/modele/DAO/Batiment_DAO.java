package org.gstfac.gestionfactulte.modele.DAO;

import org.gstfac.gestionfactulte.modele.Beans.Batiment;

import java.util.ArrayList;

public interface Batiment_DAO {
    ArrayList<Batiment> findAll();
    Batiment findByID(int ID_Batiment);
    void insert(Batiment batiment);
    void update(Batiment batiment);
    void deleteByID(int ID_Batiment);
}
