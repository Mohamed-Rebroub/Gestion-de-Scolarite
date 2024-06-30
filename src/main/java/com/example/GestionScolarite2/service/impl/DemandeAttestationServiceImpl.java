package com.example.GestionScolarite2.service.impl;

import com.example.GestionScolarite2.repository.DemandeAttestationRepository;
import com.example.GestionScolarite2.service.DemandeAttestationService;
import com.example.GestionScolarite2.entity.DemandeAttestation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DemandeAttestationServiceImpl implements DemandeAttestationService {
@Autowired
    private DemandeAttestationRepository demandeAttestationRepository;

    @Override
    public DemandeAttestation creatDemandeAttestation(DemandeAttestation demandeAttestation) {
        return demandeAttestationRepository.save(demandeAttestation);
    }

    @Override
    public DemandeAttestation getDemandeAttestationById(Long Id) {
        return demandeAttestationRepository.findById(Id).orElse(null);

    }

    @Override
    public void deleteDemandeAttestation(Long id) {
        demandeAttestationRepository.deleteById(id);    }

    @Override
    public List<DemandeAttestation> getAllDemandeAttestation() {
        return demandeAttestationRepository.findAll();

    }
}
