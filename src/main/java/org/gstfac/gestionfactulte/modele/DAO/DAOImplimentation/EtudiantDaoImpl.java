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
		entityManager = JDBCSingleton.getEntityManagerFactory().createEntityManager();
	}

    @Override
	public void save(Etudiant etudiant) {
		entityManager.getTransaction().begin();
		entityManager.persist(etudiant);
		entityManager.getTransaction().commit();
	}

	@Override
	public void update(Etudiant etd) {
		entityManager.getTransaction().begin();
		entityManager.merge(etd);
		entityManager.getTransaction().commit();
	}

	@Override
	public Etudiant getByCNE(String cne) {
		return entityManager.find(Etudiant.class, cne);
	}

	@Override
	public void deleteByCNE(String cne) {
		Etudiant etudiant = getByCNE(cne);
		entityManager.getTransaction().begin();
		entityManager.remove(etudiant);
		entityManager.getTransaction().commit();
	}

	@Override
	public void test() {

	}


	@Override
	public List<Etudiant> getAll() {
		Query query = entityManager.createQuery("SELECT e FROM Etudiant e");
		return query.getResultList();
	}





}
