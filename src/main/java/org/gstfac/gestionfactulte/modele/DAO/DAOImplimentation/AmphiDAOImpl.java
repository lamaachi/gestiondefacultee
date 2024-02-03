package org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.gstfac.gestionfactulte.modele.DAO.AmphiDAO;
import org.gstfac.gestionfactulte.modele.DAO.JDBCSingleton;
import org.gstfac.gestionfactulte.modele.entity.Amphi;

import java.util.List;

public class AmphiDAOImpl implements AmphiDAO {
    private final EntityManager entityManager;

    public AmphiDAOImpl() {
        this.entityManager = JDBCSingleton.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public void save(Amphi amphi) {
        entityManager.getTransaction().begin();
        entityManager.persist(amphi);
        entityManager.getTransaction().commit();
    }

    @Override
    public Amphi getById(int id) {
            return entityManager.find(Amphi.class, id);
    }

    @Override
    public List<Amphi> getAll() {
        Query query = entityManager.createQuery("SELECT a FROM Amphi a");
        return query.getResultList();
    }

    @Override
    public void update(Amphi amphi) {
        entityManager.getTransaction().begin();
        entityManager.merge(amphi);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        Amphi amphi = getById(id);
        entityManager.getTransaction().begin();
        entityManager.remove(amphi);
        entityManager.getTransaction().commit();
    }
}
