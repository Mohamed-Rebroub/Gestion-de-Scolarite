package com.example.GestionScolarite2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "demande_attestation")
public class DemandeAttestation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_DA;



    @Column(name = "nom")
    private String nom;

    public DemandeAttestation() {
    }

    public DemandeAttestation(String nom) {

        this.nom = nom;
    }

    public Long getId_DA() {
        return id_DA;
    }

    public void setId_DA(Long id_DA) {
        this.id_DA = id_DA;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
