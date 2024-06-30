package com.example.GestionScolarite2.controller;

import com.example.GestionScolarite2.entity.DemandeAttestation;
import com.example.GestionScolarite2.entity.FileInfo;
import com.example.GestionScolarite2.entity.User;
import com.example.GestionScolarite2.repository.ClasseRepository;
import com.example.GestionScolarite2.service.DemandeAttestationService;
import com.example.GestionScolarite2.service.FilesStorageService;
import com.example.GestionScolarite2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller

public class EtudiantController {
    @Autowired
    FilesStorageService storageService;

    @Autowired
    ClasseRepository classeRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private DemandeAttestationService demandeAttestationService;

    public EtudiantController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @GetMapping("/")
    public String etudiant(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        model.addAttribute("user", userDetails);


        return "etudiant/index";
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @GetMapping("/ept")
    public String ept() {

        return "ept/index";
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @GetMapping("/Demande")
    public String creatDemandeAtt(Model model){
        DemandeAttestation demandeAttestation = new DemandeAttestation();
        model.addAttribute("demandAttestation", demandeAttestation);
        return "etudiant/about";
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @PostMapping("/Demande")
    public String creatDemandeAtt(@ModelAttribute DemandeAttestation demandeAttestation){
        DemandeAttestation demandeAttestation1=demandeAttestationService.creatDemandeAttestation(demandeAttestation);
        return "redirect:/Demande";

    }



    @GetMapping("/pag")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public String getListFiles(Model model) {
        List<FileInfo> fileInfos = storageService.loadAllWithClasse().stream().map(fileInfo -> {
            String filename = fileInfo.getName();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FileController.class, "getFile", fileInfo.getName()).build().toString();
            fileInfo.setUrl(url);
            return fileInfo;
        }).collect(Collectors.toList());

        model.addAttribute("files", fileInfos);
        return "etudiant/pricing";
    }


}
