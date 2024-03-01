package org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.gstfac.gestionfactulte.modele.DAO.Personnel_DAO;
import org.gstfac.gestionfactulte.modele.entity.Personnel;

import java.util.List;

public class PersonnelDaoImpl implements Personnel_DAO {
    private final EntityManager entityManager;

    public PersonnelDaoImpl() {
        entityManager = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public void insert(Personnel personnel) {
        entityManager.getTransaction().begin();
        entityManager.persist(personnel);
        entityManager.getTransaction().commit();
    }

    @Override
    public Personnel getById(Long id) {
        return entityManager.find(Personnel.class, id);
    }

    @Override
    public List<Personnel> getAll() {
        Query query = entityManager.createQuery("SELECT p FROM Personnel p");
        return query.getResultList();
    }

    @Override
    public List<Personnel> getAllChefDepartement() {
        Query query = entityManager.createQuery("SELECT p FROM Personnel p WHERE p.fonction = 'ChefDepartement'");
        return query.getResultList();
    }

    @Override
    public void update(Personnel personnel) {
        entityManager.getTransaction().begin();
        entityManager.merge(personnel);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        Personnel personnel = getById(id);
        if (personnel != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(personnel);
            entityManager.getTransaction().commit();
        }
    }
}

