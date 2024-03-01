package org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation;

import org.gstfac.gestionfactulte.modele.DAO.Section_DAO;
import org.gstfac.gestionfactulte.modele.entity.Section;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class SectionDaoImpl implements Section_DAO {
    private final EntityManager entityManager;

    public SectionDaoImpl() {
        entityManager = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public void save(Section section) {
        entityManager.getTransaction().begin();
        entityManager.persist(section);
        entityManager.getTransaction().commit();
    }

    @Override
    public Section getById(int id) {
        return entityManager.find(Section.class, id);
    }

    @Override
    public List<Section> getAll() {
        Query query = entityManager.createQuery("SELECT s FROM Section s");
        return query.getResultList();
    }

    @Override
    public void update(Section section) {
        entityManager.getTransaction().begin();
        entityManager.merge(section);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        Section section = getById(id);
        if (section != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(section);
            entityManager.getTransaction().commit();
        }
    }
}