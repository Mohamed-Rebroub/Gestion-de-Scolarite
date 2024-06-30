package com.example.GestionScolarite2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "AnneeScolaire")
public class AnneeScolaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_AnneeScolaire;
    @Column(name = "Annee")

    private int Annee;

    public Long getId_AnneeScolaire() {
        return id_AnneeScolaire;
    }

    public void setId_AnneeScolaire(Long id_AnneeScolaire) {
        this.id_AnneeScolaire = id_AnneeScolaire;
    }

    public int getAnnee() {
        return Annee;
    }

    public void setAnnee(int annee) {
        Annee = annee;
    }
}
