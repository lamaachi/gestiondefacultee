package org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.gstfac.gestionfactulte.modele.DAO.Departement_DAO;
import org.gstfac.gestionfactulte.modele.DAO.JDBCSingleton;
import org.gstfac.gestionfactulte.modele.entity.Departement;

import java.util.ArrayList;

public class DepartementDAOImpl implements Departement_DAO {

    private final EntityManager entityManager;

    public DepartementDAOImpl() {
        entityManager = JDBCSingleton.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public void insert(Departement departement) {
        entityManager.getTransaction().begin();
        entityManager.persist(departement);
        entityManager.getTransaction().commit();
    }

    @Override
    public Departement findByID(int id) {
        return entityManager.find(Departement.class, id);
    }

    @Override
    public ArrayList<Departement> findAll() {
        Query query = entityManager.createQuery("SELECT d FROM Departement d");
        return (ArrayList<Departement>) query.getResultList();
    }

    @Override
    public void update(Departement departement) {
        entityManager.getTransaction().begin();
        entityManager.merge(departement);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteByID(int id) {
        Departement departement = findByID(id);
        entityManager.getTransaction().begin();
        entityManager.remove(departement);
        entityManager.getTransaction().commit();
    }
}
