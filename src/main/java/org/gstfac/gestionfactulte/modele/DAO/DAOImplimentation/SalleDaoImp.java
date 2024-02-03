package org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.gstfac.gestionfactulte.modele.DAO.JDBCSingleton;
import org.gstfac.gestionfactulte.modele.DAO.SalleDAO;
import org.gstfac.gestionfactulte.modele.entity.Salle;

import java.util.List;

public class SalleDaoImp implements SalleDAO {
    private final EntityManager entityManager;

    public SalleDaoImp() {
        this.entityManager = JDBCSingleton.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public void save(Salle Salle) {
        entityManager.getTransaction().begin();
        entityManager.persist(Salle);
        entityManager.getTransaction().commit();
    }

    @Override
    public Salle getById(int id) {
        return entityManager.find(Salle.class, id);
    }

    @Override
    public List<Salle> getAll() {
        Query query = entityManager.createQuery("SELECT b FROM Salle b");
        return query.getResultList();
    }

    @Override
    public void update(Salle Salle) {
        entityManager.getTransaction().begin();
        entityManager.merge(Salle);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        Salle Salle = getById(id);
        entityManager.getTransaction().begin();
        entityManager.remove(Salle);
        entityManager.getTransaction().commit();
    }
}
