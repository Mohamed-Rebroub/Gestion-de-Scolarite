package com.example.GestionScolarite2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.File;

@Data
@Entity
@Table(name = "emploi_du_temps")
public class EmploiDuTemps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_EDT;

 private String fichierPDF;

    @OneToOne
    @JoinColumn(name = "id_classe")
    private classe classe;

    public EmploiDuTemps(String fichierPDF, com.example.GestionScolarite2.entity.classe classe) {
        this.fichierPDF = fichierPDF;
        this.classe = classe;
    }

    public EmploiDuTemps() {
    }


    public String getIfichierPDFUrl() {

        if(fichierPDF == null) {
            return "/fichier/user.pdf";
        }else {
            String UPLOAD_DIR = System.getProperty("user.dir") + "/src/main/resources/static/uploadspdf/";
            if(new File((UPLOAD_DIR + fichierPDF.trim())).exists()) {
                return "/uploadspdf/" + fichierPDF.trim();
            }
            else {
                return "/fichier/user.pdf";
            }
        }
}

    public Long getId_EDT() {
        return id_EDT;
    }

    public void setId_EDT(Long id_EDT) {
        this.id_EDT = id_EDT;
    }

    public String getFichierPDF() {
        return fichierPDF;
    }

    public void setFichierPDF(String fichierPDF) {
        this.fichierPDF = fichierPDF;
    }

    public com.example.GestionScolarite2.entity.classe getClasse() {
        return classe;
    }

    public void setClasse(com.example.GestionScolarite2.entity.classe classe) {
        this.classe = classe;
    }
     }