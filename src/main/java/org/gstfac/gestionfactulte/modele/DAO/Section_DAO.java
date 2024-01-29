package org.gstfac.gestionfactulte.modele.DAO;

import org.gstfac.gestionfactulte.modele.entity.Section;

import java.util.ArrayList;
public interface Section_DAO {
    ArrayList<Section> findAll();
    Section findByID(int ID_Section);
    void insert(Section section);
    void update(Section section);
    void deleteByID(int ID_Section);
}
