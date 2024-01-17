package org.gstfac.gestionfactulte.modele.DAO;

import org.gstfac.gestionfactulte.modele.Beans.Personnel;

import java.util.ArrayList;

public interface Personnel_DAO {
    Personnel Login(String ident,String Password);
    Personnel Register(Personnel personnel);
    ArrayList<Personnel> findAll();
    Personnel findByID(int ID_Personnel);
    void insert(Personnel personnel);
    void update(Personnel personnel);
    void deleteByID(int ID_Personnel);
}
