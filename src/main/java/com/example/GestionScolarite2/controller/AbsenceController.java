package com.example.GestionScolarite2.controller;

import com.example.GestionScolarite2.entity.Absence;
import com.example.GestionScolarite2.service.AbsenceService;
import com.example.GestionScolarite2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    @Autowired
    private UserService userService;

    @GetMapping("/absences")
    public String getAllAbsences(Model model) {
        List<Absence> absences = absenceService.getAllAbsences();
        model.addAttribute("absences", absences);
        return "admin/absences";
    }

    @GetMapping("/absences/new")
    public String showCreateForm(Model model) {
        model.addAttribute("absence", new Absence());
        return "admin/create-absence";
    }

    @PostMapping("/absences")
    public String createAbsence(@ModelAttribute Absence absence) {

        absenceService.createAbsence(absence);
        return "redirect:/admin/absences";
    }



    @GetMapping("/absences/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Absence absence = absenceService.getAbsenceById(id);
        model.addAttribute("absence", absence);
        return "admin/edit-absence";
    }

    @PostMapping("/absences/{id}")
    public String updateAbsence(@PathVariable("id") Long id, @ModelAttribute Absence absence) {
        absenceService.updateAbsence(id, absence);
        return "redirect:/admin/absences";
    }

    @GetMapping("/absences/delete/{id}")
    public String deleteAbsence(@PathVariable("id") Long id) {
        absenceService.deleteAbsence(id);
        return "redirect:/admin/absences";
    }
}
