package com.example.GestionScolarite2.repository;


import com.example.GestionScolarite2.entity.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AbsenceRepository extends JpaRepository<Absence, Long> {

}
