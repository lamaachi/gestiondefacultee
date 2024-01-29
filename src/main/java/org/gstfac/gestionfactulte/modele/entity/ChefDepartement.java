package org.gstfac.gestionfactulte.modele.entity;

import com.master.universite.mediator.ChefDepartementMediator;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

import java.util.List;

@Entity
public class ChefDepartement extends Personnel {

    @OneToMany(mappedBy = "sender")
    private List<Message> sentMessages;

    @Transient
    private ChefDepartementMediator mediator;


    public ChefDepartement() {
    }

//    public void sendMessage(String message) {
//        mediator.sendMessage(this, message);
//    }

    public String receiveMessage(String message) {
        return message;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }
}
