package com.example.GestionScolarite2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Matieres")
public class Matieres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Mat;

    @Column(name = "nom")
    private String nom;



}
