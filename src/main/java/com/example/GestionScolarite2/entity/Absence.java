package com.example.GestionScolarite2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "absence")
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_absence;
    @Column(name = "Annee")

    private int nb_h;

    @OneToOne
    @JoinColumn(name = "id_e")
    private User   user;

    @ManyToOne
    @JoinColumn(name = "id_Mat")
    private Matieres Matieres;

    public Absence(Long id_absence, int nb_h, User user, com.example.GestionScolarite2.entity.Matieres matieres) {
        this.id_absence = id_absence;
        this.nb_h = nb_h;
        this.user = user;
        Matieres = matieres;
    }
    public Absence() {}
}
