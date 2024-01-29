package org.gstfac.gestionfactulte.modele.DAO;

import org.gstfac.gestionfactulte.modele.entity.Message;

import java.util.List;

public interface Message_DAO {
    void insert(Message message);
    Message findById(int id);
    List<Message> findAll();
    void update(Message message);
    void deleteById(int id);
}
