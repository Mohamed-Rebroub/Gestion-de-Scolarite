package com.example.GestionScolarite2.service.impl;

import com.example.GestionScolarite2.entity.Matieres;
import com.example.GestionScolarite2.repository.MatieresRepository;
import com.example.GestionScolarite2.service.MatieresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatieresServiceImpl implements MatieresService {

    @Autowired
    private  MatieresRepository matieresRepository;



    @Override
    public Matieres creatMatier(Matieres matiers) {
        return matieresRepository.save(matiers);
    }


    @Override
    public Matieres getMatieresById(Long Id) {
        return matieresRepository.findById(Id).orElse(null);
    }


    @Override
    public Matieres updateMatieres(Long id, Matieres updatedMatieres) {

        Matieres oldMatieres = getMatieresById(id);
        if (oldMatieres != null) {
            oldMatieres.setId_Mat(updatedMatieres.getId_Mat());
            oldMatieres.setNom(updatedMatieres.getNom());
            return matieresRepository.save(oldMatieres);

        }
        return null;

    }

    @Override
    public void deleteMatieres(Long id) {
        matieresRepository.deleteById(id);
    }


    @Override
    public List<Matieres> getAllMatieres() {
        return matieresRepository.findAll();
    }

}
