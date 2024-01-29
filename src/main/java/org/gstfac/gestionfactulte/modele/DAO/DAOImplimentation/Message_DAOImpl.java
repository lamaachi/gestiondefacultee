package org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation;

import jakarta.persistence.EntityManager;
import org.gstfac.gestionfactulte.modele.DAO.Message_DAO;
import org.gstfac.gestionfactulte.modele.entity.Message;

import java.util.List;

public class Message_DAOImpl implements Message_DAO {
    @Override
    public void insert(Message message) {

    }

    @Override
    public Message findById(int id) {
        return null;
    }

    @Override
    public List<Message> findAll() {
        return null;
    }

    @Override
    public void update(Message message) {

    }

    @Override
    public void deleteById(int id) {

    }
}
