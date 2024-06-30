package com.example.GestionScolarite2.service.impl;

import com.example.GestionScolarite2.entity.Absence;
import com.example.GestionScolarite2.entity.FileInfo;
import com.example.GestionScolarite2.entity.Matieres;
import com.example.GestionScolarite2.entity.User;
import com.example.GestionScolarite2.repository.AbsenceRepository;
import com.example.GestionScolarite2.repository.MatieresRepository;
import com.example.GestionScolarite2.repository.UserRepository;
import com.example.GestionScolarite2.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AbsenceServiceimpl implements AbsenceService {
    @Autowired
    private AbsenceRepository absenceRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MatieresRepository matieresRepository;




    @Override
    public Absence createAbsence(Absence absence) {
        User user = userRepository.findByName(absence.getUser().getName());
        Matieres matieres = matieresRepository.findByNom(absence.getMatieres().getNom());

        if (user == null) {
            throw new IllegalArgumentException("User not found: " + absence.getUser().getName());
        }

        if (matieres == null) {
            throw new IllegalArgumentException("Matieres not found: " + absence.getMatieres().getNom());
        }

        absence.setUser(user);
        absence.setMatieres(matieres);

        return absenceRepository.save(absence);
    }
    @Override
    public List<Absence> getAbsenceByUserId(Long id) {
        return (List<Absence>) absenceRepository.findById(id).orElse(null);
    }

    @Override
    public Absence getAbsenceById(Long id) {
        return absenceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Absence> loadAllWithUser() {
        return List.of();
    }

    @Override
    public Absence updateAbsence(Long id, Absence updatedAbsence) {
        if (absenceRepository.existsById(id)) {
            updatedAbsence.setId_absence(id);
            return absenceRepository.save(updatedAbsence);
        }
        return null;
    }

    @Override
    public void deleteAbsence(Long id) {
        absenceRepository.deleteById(id);
    }

    @Override
    public List<Absence> getAllAbsences() {
        return absenceRepository.findAll();
    }
}
