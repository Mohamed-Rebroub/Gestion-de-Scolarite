package com.example.GestionScolarite2.repository;

import com.example.GestionScolarite2.entity.DemandeAttestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeAttestationRepository extends JpaRepository<DemandeAttestation, Long> {
}
