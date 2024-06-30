package com.example.GestionScolarite2.service.impl;


import com.example.GestionScolarite2.entity.AnneeScolaire;
import com.example.GestionScolarite2.repository.AnneeScolaireRepository;
import com.example.GestionScolarite2.service.AnneeScolaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnneeScolaireServiceImp implements AnneeScolaireService {
    @Autowired
    public final AnneeScolaireRepository anneeScolaireRepository;


    public AnneeScolaireServiceImp(AnneeScolaireRepository anneeScolaireRepository) {
        this.anneeScolaireRepository = anneeScolaireRepository;
    }
@Override
    public AnneeScolaire creatAnneeScolaire(AnneeScolaire anneeScolaire) {

        return anneeScolaireRepository.save(anneeScolaire);
    }
    @Override

    public AnneeScolaire getAnneeScolaireById(Long Id) {
        return anneeScolaireRepository.findById(Id).orElse(null);
    }
    @Override

    public AnneeScolaire updateAnneeScolaire(Long id, AnneeScolaire updatedAnneeScolaire) {

        AnneeScolaire oldAnneeScolaire = getAnneeScolaireById(id);
        if (oldAnneeScolaire != null) {
            oldAnneeScolaire.setId_AnneeScolaire(updatedAnneeScolaire.getId_AnneeScolaire());
            oldAnneeScolaire.setAnnee(updatedAnneeScolaire.getAnnee());
            return anneeScolaireRepository.save(oldAnneeScolaire);

        }
        return null;

    }
    @Override

    public void deleteAnneeScolaire(Long id) {
        anneeScolaireRepository.deleteById(id);
    }
    @Override

    public List<AnneeScolaire> getAllAnneeScolaire() {
        return anneeScolaireRepository.findAll();
    }


}
