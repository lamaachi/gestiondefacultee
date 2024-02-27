package org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.gstfac.gestionfactulte.modele.DAO.FillierDAO;
import org.gstfac.gestionfactulte.modele.DAO.JDBCSingleton;
import org.gstfac.gestionfactulte.modele.entity.Filiere;

import java.util.List;

public class FillierDaoImpl implements FillierDAO {
    private final EntityManager entityManager;

    public FillierDaoImpl() {
        entityManager = JDBCSingleton.getEntityManagerFactory().createEntityManager();
    }


    @Override
    public void save(Filiere Filiere) {
        entityManager.getTransaction().begin();
        entityManager.persist(Filiere);
        entityManager.getTransaction().commit();
    }

    @Override
    public Filiere getById(int id) {
        return entityManager.find(Filiere.class,id);
    }

    @Override
    public List<Filiere> getAll() {
        Query query = entityManager.createQuery("SELECT f FROM Filiere f");
        return query.getResultList();
    }

    @Override
    public void update(Filiere Filiere) {
        entityManager.getTransaction().begin();
        entityManager.merge(Filiere);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        Filiere Filiere = getById(id);
        entityManager.getTransaction().begin();
        entityManager.remove(Filiere);
        entityManager.getTransaction().commit();
    }
}
