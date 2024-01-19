package org.gstfac.gestionfactulte.modele.DAO;

import org.gstfac.gestionfactulte.modele.Beans.Etudiant;

import java.util.ArrayList;

public interface Etudiant_DAO {
	ArrayList<Etudiant>  findAll();
	void insertEtd(Etudiant etd);
	void update(Etudiant etd, int ID_Etudiant);
	void deleteByID(int ID_Etudiant);
	Etudiant findByCode(String code);
	Etudiant findByID(int ID_Etudiant);
}

