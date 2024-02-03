package org.gstfac.gestionfactulte.modele.DAO;

import org.gstfac.gestionfactulte.modele.entity.Amphi;

import java.util.List;

public interface AmphiDAO {
    void save(Amphi amphi);
    Amphi getById(int id);
    List<Amphi> getAll();
    void update(Amphi amphi);
    void delete(int id);
}
