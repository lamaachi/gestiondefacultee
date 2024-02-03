package org.gstfac.gestionfactulte.modele.DAO;

import org.gstfac.gestionfactulte.modele.entity.Salle;

import java.util.List;

public interface SalleDAO {
    void save(Salle Salle);
    Salle getById(int id);
    List<Salle> getAll();
    void update(Salle Salle);
    void delete(int id);
}
