package com.example.GestionScolarite2.service;

import com.example.GestionScolarite2.entity.DemandeAttestation;

import java.util.List;

public interface DemandeAttestationService {





   DemandeAttestation creatDemandeAttestation(DemandeAttestation demandeAttestation) ;

     DemandeAttestation getDemandeAttestationById(Long Id) ;

    /*
        public Note updateDemandeAttestation(Long id, DemandeAttestation updatedDemandeAttestation) {

            DemandeAttestation oldDemandeAttestation=getDemandeAttestationById(id);
            if (oldDemandeAttestation!= null){

                oldDemandeAttestation.setId_DA(updatedDemandeAttestation);

                return demandeAttestationRepository.save(oldDemandeAttestation);

            }
            return null;

        }*/
     void deleteDemandeAttestation(Long id);

     List<DemandeAttestation> getAllDemandeAttestation();
}
