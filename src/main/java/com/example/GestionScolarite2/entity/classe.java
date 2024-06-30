package com.example.GestionScolarite2.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "classe")
public class classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_classe;
    @Column(name = "nom")
    private String nom;

    @Column(name = "AnneeScolaire")
    private int AnneeScolaire;

    public Long getId_classe() {
        return id_classe;
    }

    public void setId_classe(Long id_classe) {
        this.id_classe = id_classe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAnneeScolaire() {
        return AnneeScolaire;
    }

    public void setAnneeScolaire(int anneeScolaire) {
        AnneeScolaire = anneeScolaire;
    }
}
