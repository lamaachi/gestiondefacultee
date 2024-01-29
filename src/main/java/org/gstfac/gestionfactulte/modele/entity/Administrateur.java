package org.gstfac.gestionfactulte.modele.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
public class Administrateur extends Personnel {
    public Administrateur() {
    }
}
