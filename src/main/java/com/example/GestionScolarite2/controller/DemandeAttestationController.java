package com.example.GestionScolarite2.controller;

import com.example.GestionScolarite2.entity.DemandeAttestation;
import com.example.GestionScolarite2.repository.DemandeAttestationRepository;
import com.example.GestionScolarite2.service.DemandeAttestationService;
import com.example.GestionScolarite2.service.impl.DemandeAttestationServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Controller
@RequestMapping("/demande")
public class DemandeAttestationController {

    @Autowired
    public DemandeAttestationService demandeAttestationService;
    @Autowired
    public DemandeAttestationRepository demandeAttestationRepository;

    @GetMapping("/list")
    public String getAllDemandeAttestation(Model model) {


        List<DemandeAttestation> demandeAttestations = demandeAttestationRepository.findAll();


        model.addAttribute("demandeAttestations", demandeAttestations);

        return "admin/demandes";
    }

        @GetMapping("/c")
    public String creatDemandeAttestation(Model model){
    DemandeAttestation demandeAttestation = new DemandeAttestation();
    model.addAttribute("demandAttestation", demandeAttestation);
    return "etudiant/demande-attestation";
}

  @PostMapping("/c")
    public String creatDemandeAttestation(@ModelAttribute DemandeAttestation demandeAttestation){
    DemandeAttestation demandeAttestation1=demandeAttestationService.creatDemandeAttestation(demandeAttestation);
      return "redirect:/demande/c";

  }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {

        // delete employee
        demandeAttestationService.deleteDemandeAttestation(id);

        // return to list
        return "redirect:/demande/list";
    }

     }


