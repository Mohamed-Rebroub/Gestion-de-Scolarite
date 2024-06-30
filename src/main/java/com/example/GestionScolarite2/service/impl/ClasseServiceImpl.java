package com.example.GestionScolarite2.service.impl;

import com.example.GestionScolarite2.entity.classe;
import com.example.GestionScolarite2.repository.ClasseRepository;
import com.example.GestionScolarite2.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClasseServiceImpl implements ClasseService {

    @Autowired
    public ClasseRepository classeRepository;

    public ClasseServiceImpl(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Override
    public classe creatClasse(classe classe) {
        return classeRepository.save(classe);    }

    @Override
    public classe getclasseById(Long Id) {
        return classeRepository.findById(Id).orElse(null);
    }

    @Override
    public classe updateClasse(Long id, classe updatedClasse) {
        classe oldClasse = getclasseById(id);
        if (oldClasse != null) {
            oldClasse.setId_classe(updatedClasse.getId_classe());
            oldClasse.setNom(updatedClasse.getNom());
            oldClasse.setAnneeScolaire(updatedClasse.getAnneeScolaire());
            return classeRepository.save(oldClasse);

        }
        return null;
    }

    @Override
    public void deleteClass(Long id) {
        classeRepository.deleteById(id);
    }

    @Override
    public List<classe> getAllclasse() {
        return classeRepository.findAll();
    }
}
