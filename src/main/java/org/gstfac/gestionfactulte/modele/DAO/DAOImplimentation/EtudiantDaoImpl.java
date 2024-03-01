package org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.gstfac.gestionfactulte.modele.entity.Etudiant;
import org.gstfac.gestionfactulte.modele.DAO.Etudiant_DAO;
import org.gstfac.gestionfactulte.modele.DAO.JDBCSingleton;

import java.util.List;

public class EtudiantDaoImpl implements Etudiant_DAO {
		private final EntityManager entityManager;

		public EtudiantDaoImpl() {
			entityManager = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
		}

		@Override
		public void insert(Etudiant etudiant) {
			entityManager.getTransaction().begin();
			entityManager.persist(etudiant);
			entityManager.getTransaction().commit();
		}

		@Override
		public Etudiant findById(Long id) {
			return entityManager.find(Etudiant.class, id);
		}

		@Override
		public List<Etudiant> findAll() {
			Query query = entityManager.createQuery("SELECT e FROM Etudiant e");
			return query.getResultList();
		}

		@Override
		public void update(Etudiant etudiant) {
			entityManager.getTransaction().begin();
			entityManager.merge(etudiant);
			entityManager.getTransaction().commit();
		}

		@Override
		public void delete(Long id) {
			Etudiant etudiant = findById(id);
			entityManager.getTransaction().begin();
			entityManager.remove(etudiant);
			entityManager.getTransaction().commit();
		}
	}
