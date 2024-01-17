package org.gstfac.gestionfactulte.modele.DAO;

import org.gstfac.gestionfactulte.modele.Beans.Sections;

import java.util.ArrayList;

public interface Section_DAO {
    ArrayList<Sections> findAll();
    Sections findByID(int ID_Section);
    void insert(Sections section);
    void update(Sections section);
    void deleteByID(int ID_Section);
}
