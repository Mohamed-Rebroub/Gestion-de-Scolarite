package com.example.GestionScolarite2.service.impl;

import com.example.GestionScolarite2.entity.EmploiDuTemps;
import com.example.GestionScolarite2.repository.EmploiDuTempsRepository;
import com.example.GestionScolarite2.service.EmploiDuTempsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
@Service
public class EmploiDuTempsServiceImpl implements EmploiDuTempsService {

    @Autowired
    private EmploiDuTempsRepository emploiDuTempsRepository;


    @Override
    public EmploiDuTemps createEmploiDuTemps(EmploiDuTemps emploiDuTemps) {
        return emploiDuTempsRepository.save(emploiDuTemps);
    }

    @Override
    public List<EmploiDuTemps> getAllEmploiDuTemps() {
        return emploiDuTempsRepository.findAll();
    }

    @Override
        public EmploiDuTemps getEmploiDuTemps(Long id) {
        return emploiDuTempsRepository.findById(id).orElse(null);
    }

    @Override
    public EmploiDuTemps getEmploiDuTempsById(Long Id) {
        return emploiDuTempsRepository.findById(Id).orElse(null);
    }


    @Override
    public void deleteEmploiDuTemps(Long id) {
       emploiDuTempsRepository.deleteById(id);
    }

    private static final String UPLOAD_DIR = "chemin/vers/le/dossier/upload/";
    @Override

    public String updatePDF(String oldPDFName, MultipartFile pdf)throws IOException {
        // Vérifier si un fichier PDF est fourni
        if (pdf != null && !pdf.isEmpty()) {
            // Supprimer l'ancien fichier PDF s'il existe
            if (!StringUtils.isEmpty(oldPDFName)) {
                File oldPDF = new File(UPLOAD_DIR + oldPDFName);
                if (oldPDF.exists() && oldPDF.isFile()) {
                    oldPDF.delete();
                }
            }
            // Téléverser le nouveau fichier PDF
            return uploadPDF(pdf);
        }
        // Aucun fichier PDF fourni, retourner le nom de l'ancien fichier
        return oldPDFName;
    }
    @Override

    public String uploadPDF(MultipartFile pdf) throws IOException {
        // Générer un nom unique pour le fichier PDF
        String fileName = StringUtils.cleanPath(pdf.getOriginalFilename());
        // Assurez-vous que le nom de fichier est valide
        if (fileName.contains("..")) {
            throw new IOException("Nom de fichier invalide : " + fileName);
        }
        // Chemin complet du fichier PDF
        String filePath = UPLOAD_DIR + fileName;
        // Enregistrer le fichier PDF sur le disque
        File dest = new File(filePath);
        pdf.transferTo(dest);
        return fileName;
    }
}
