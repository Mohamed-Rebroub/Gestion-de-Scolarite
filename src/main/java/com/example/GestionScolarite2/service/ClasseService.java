package com.example.GestionScolarite2.service;

import com.example.GestionScolarite2.entity.classe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClasseService {

   classe creatClasse(classe classe);

     classe getclasseById(Long Id);

     classe updateClasse(Long id, classe updatedClasse) ;

     void deleteClass(Long id);

     List<classe> getAllclasse();
}
