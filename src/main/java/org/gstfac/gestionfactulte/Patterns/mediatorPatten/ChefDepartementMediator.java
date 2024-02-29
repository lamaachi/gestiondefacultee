package org.gstfac.gestionfactulte.Patterns.mediatorPatten;

import org.gstfac.gestionfactulte.modele.entity.ChefDepartement;
import org.gstfac.gestionfactulte.modele.entity.Message;

import java.util.List;

public interface ChefDepartementMediator {
    void sendMessage(Message message);
    void addChefDepartement(ChefDepartement chefDepartement);
    List<Message> receiveMessages();
    List<ChefDepartement> getChefsDepartement();
}
