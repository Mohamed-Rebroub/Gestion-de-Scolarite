package com.example.GestionScolarite2.service;


import com.example.GestionScolarite2.entity.AnneeScolaire;

import java.util.List;

public interface AnneeScolaireService {

    public AnneeScolaire creatAnneeScolaire(AnneeScolaire anneeScolaire) ;

    public AnneeScolaire getAnneeScolaireById(Long Id) ;

    public AnneeScolaire updateAnneeScolaire(Long id, AnneeScolaire updatedAnneeScolaire) ;
    public void deleteAnneeScolaire(Long id) ;

    public List<AnneeScolaire> getAllAnneeScolaire() ;

    }
