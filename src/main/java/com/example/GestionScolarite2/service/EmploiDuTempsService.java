package com.example.GestionScolarite2.service;

import com.example.GestionScolarite2.entity.EmploiDuTemps;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmploiDuTempsService {

    EmploiDuTemps createEmploiDuTemps(EmploiDuTemps emploiDuTemps);

    String updatePDF(String oldPDFName, MultipartFile pdf) throws IOException;

    List<EmploiDuTemps> getAllEmploiDuTemps();

    EmploiDuTemps getEmploiDuTemps(Long id);
    String uploadPDF(MultipartFile pdf) throws IOException;
     EmploiDuTemps getEmploiDuTempsById(Long Id) ;
    void deleteEmploiDuTemps(Long id);




}
