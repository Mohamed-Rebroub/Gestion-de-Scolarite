package com.example.GestionScolarite2.repository;

import com.example.GestionScolarite2.entity.classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<classe, Long> {
}
