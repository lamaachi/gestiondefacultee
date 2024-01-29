package org.gstfac.gestionfactulte.modele.DAO;

import org.gstfac.gestionfactulte.modele.entity.Etudiant;

import java.util.ArrayList;
import java.util.List;

public interface Etudiant_DAO {
	List<Etudiant> getAll();
	Etudiant getByCNE(String cne);
	void save(Etudiant etd);
	void update(Etudiant etd);
	void deleteByCNE(String CNE);
}

