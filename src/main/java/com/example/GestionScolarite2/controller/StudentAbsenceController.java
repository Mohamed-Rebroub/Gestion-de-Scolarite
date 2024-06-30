package com.example.GestionScolarite2.controller;

import com.example.GestionScolarite2.entity.Absence;
import com.example.GestionScolarite2.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/etudiant")
public class StudentAbsenceController {

    @Autowired
    private AbsenceService absenceService;

    @GetMapping("/absences")
    public String getStudentAbsences(Model model, Authentication authentication) {
        String email = authentication.getName();
        List<Absence> absences = absenceService.getAllAbsences(); // Replace this with a method to fetch absences by student email
        model.addAttribute("absences", absences);
        return "etudiant/absences";
    }
}
