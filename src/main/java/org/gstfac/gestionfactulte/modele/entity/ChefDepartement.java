package org.gstfac.gestionfactulte.modele.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

import java.util.List;

@Entity
public class ChefDepartement extends Personnel {

    @OneToMany(mappedBy = "sender")
    private List<Message> sentMessages;

    @Transient
    private ChefDepartement mediator;


    public ChefDepartement() {
    }

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
