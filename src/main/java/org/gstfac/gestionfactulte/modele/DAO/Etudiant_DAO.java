package org.gstfac.gestionfactulte.modele.DAO;

import org.gstfac.gestionfactulte.modele.entity.Etudiant;

import java.util.ArrayList;
import java.util.List;

public interface Etudiant_DAO {
		void insert(Etudiant etudiant);
		Etudiant findById(Long id);
		List<Etudiant> findAll();
		void update(Etudiant etudiant);
		void delete(Long id);
	}


