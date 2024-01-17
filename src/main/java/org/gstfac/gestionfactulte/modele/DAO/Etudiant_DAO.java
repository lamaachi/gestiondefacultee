package org.gstfac.gestionfactulte.modele.DAO;

import org.gstfac.gestionfactulte.modele.Beans.Etudiant;

import java.util.ArrayList;

public interface Etudiant_DAO {
	ArrayList<Etudiant>  findAll();
	Etudiant findByCNE(String CNE);
	void insert(Etudiant etd);
	void update(Etudiant etd, String CNE);
	void deleteByCNE(String CNE);
}

