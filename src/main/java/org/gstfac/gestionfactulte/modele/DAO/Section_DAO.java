package org.gstfac.gestionfactulte.modele.DAO;

import org.gstfac.gestionfactulte.modele.entity.Section;

import java.util.List;

public interface Section_DAO {
    void save(Section section);
    Section getById(int id);
    List<Section> getAll();
    void update(Section section);
    void delete(int id);
}