package org.gstfac.gestionfactulte.modele.DAO;
import org.gstfac.gestionfactulte.modele.entity.Personnel;

import java.util.List;

public interface Personnel_DAO {

    void insert(Personnel personnel);
    Personnel getById(Long id);
    List<Personnel> getAll();
    List<Personnel> getAllChefDepartement();
    void update(Personnel personnel);
    void delete(Long id);
}