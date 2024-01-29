package org.gstfac.gestionfactulte.modele.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
public class Doyen extends Personnel {
    @Column(insertable = false, updatable = false)
    private String fonction;
    public Doyen() {
    }
}
