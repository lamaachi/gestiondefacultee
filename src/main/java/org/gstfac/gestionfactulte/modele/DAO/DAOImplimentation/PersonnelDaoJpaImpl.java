package org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.gstfac.gestionfactulte.modele.Beans.Personnel;
import org.gstfac.gestionfactulte.modele.DAO.Personnel_DAO;
import org.gstfac.gestionfactulte.modele.DAO.JDBCSingleton;

import java.util.ArrayList;

public class PersonnelDaoJpaImpl implements Personnel_DAO {
    private final EntityManager entityManager;

    public PersonnelDaoJpaImpl() {
        entityManager = JDBCSingleton.getEntityManagerFactory().createEntityManager();
    }
    @Override
    public Personnel Login(String ident, String Password) {
        try {
            Query query = entityManager.createQuery("SELECT p FROM Personnel p WHERE p.identifiant = :ident AND p.password = :password");
            query.setParameter("ident", ident);
            query.setParameter("password", Password);

            return (Personnel) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Identifiant ou mot de passe incorrect!");
            return null;
        }
    }

    @Override
    public Personnel Register(Personnel personnel) {
        entityManager.getTransaction().begin();
        entityManager.persist(personnel);
        entityManager.getTransaction().commit();
        System.out.println("Inscription réussie!");

        return personnel;
    }

    @Override
    public ArrayList<Personnel> findAll() {
        Query query = entityManager.createQuery("SELECT p FROM Personnel p ORDER BY p.ID_Personnel");
        ArrayList<Personnel> listePersonnel = new ArrayList<>(query.getResultList());

        if (!listePersonnel.isEmpty()) {
            System.out.println("Recherche terminée!");
        } else {
            System.out.println("Table vide!");
        }

        return listePersonnel;
    }

    @Override
    public Personnel findByID(int ID_Personnel) {
        return entityManager.find(Personnel.class, ID_Personnel);
    }

    @Override
    public void insert(Personnel personnel) {
        entityManager.getTransaction().begin();
        entityManager.persist(personnel);
        entityManager.getTransaction().commit();
        System.out.println("Personnel inséré avec succès!");
    }

    @Override
    public void update(Personnel personnel) {
        entityManager.getTransaction().begin();
        entityManager.merge(personnel);
        entityManager.getTransaction().commit();
        System.out.println("Personnel modifié avec succès!");
    }

    @Override
    public void deleteByID(int ID_Personnel) {
        Personnel personnel = findByID(ID_Personnel);
        if (personnel != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(personnel);
            entityManager.getTransaction().commit();
            System.out.println("Personnel supprimé avec succès!");
        } else {
            System.out.println("ID_Personnel non valide!");
        }
    }
}
