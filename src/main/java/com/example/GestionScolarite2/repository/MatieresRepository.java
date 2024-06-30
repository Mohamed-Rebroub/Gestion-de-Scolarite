package com.example.GestionScolarite2.repository;


import com.example.GestionScolarite2.entity.Matieres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatieresRepository extends JpaRepository<Matieres, Long> {
    Matieres findByNom(String nom);

}
