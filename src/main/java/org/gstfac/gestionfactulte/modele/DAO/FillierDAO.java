package org.gstfac.gestionfactulte.modele.DAO;

import org.gstfac.gestionfactulte.modele.entity.Filiere;

import java.util.List;

public interface FillierDAO {
    void save(Filiere Filiere);
    Filiere getById(int id);
    List<Filiere> getAll();
    void update(Filiere Filiere);
    void delete(int id);
}
