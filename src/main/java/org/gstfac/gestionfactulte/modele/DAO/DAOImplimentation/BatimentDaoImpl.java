package org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation;

import org.gstfac.gestionfactulte.modele.entity.Batiment;
import org.gstfac.gestionfactulte.modele.DAO.Batiment_DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import org.gstfac.gestionfactulte.modele.entity.Batiment;
public class BatimentDaoImpl implements Batiment_DAO {

    private final EntityManager entityManager;

    public BatimentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public ArrayList<Batiment> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM Batiment b");
        return (ArrayList<Batiment>) query.getResultList();
    }

    @Override
    public Batiment findByID(int ID_Batiment) {
        return entityManager.find(Batiment.class, ID_Batiment);
    }

    @Override
    public void insert(Batiment batiment) {
        entityManager.getTransaction().begin();
        entityManager.persist(batiment);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Batiment batiment) {
        entityManager.getTransaction().begin();
        entityManager.merge(batiment);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteByID(int ID_Batiment) {
        Batiment batiment = findByID(ID_Batiment);
        if (batiment != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(batiment);
            entityManager.getTransaction().commit();
        }
    }
}
