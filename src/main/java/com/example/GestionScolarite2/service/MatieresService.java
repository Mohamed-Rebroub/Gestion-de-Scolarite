package com.example.GestionScolarite2.service;


import com.example.GestionScolarite2.entity.Matieres;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface MatieresService {



     Matieres creatMatier(Matieres Matiers) ;

     Matieres getMatieresById(Long Id) ;

     Matieres updateMatieres(Long id, Matieres updatedMatieres);

     void deleteMatieres(Long id) ;

     List<Matieres> getAllMatieres() ;
}
