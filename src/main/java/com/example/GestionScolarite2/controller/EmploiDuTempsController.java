package com.example.GestionScolarite2.controller;
/*

import com.example.GestionScolarite2.entity.FileInfo;
import com.example.GestionScolarite2.entity.classe;
import com.example.GestionScolarite2.service.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ED")
public class FileController {

    @Autowired
    FilesStorageService storageService;

    @GetMapping("/new")
    public String homepage() {
        return "redirect:/ED/files";
    }

    @GetMapping("/files/new") // Unique mapping for newFile(Model)
    public String newFile(Model model) {
        return "admin/upload_form";
    }

    @PostMapping("/files/upload")
    public String uploadFiles(Model model, @RequestParam("files") MultipartFile[] files,
                              @RequestParam("class")classe clas  ) {
        List<String> messages = new ArrayList<>();

        Arrays.asList(files).stream().forEach(file -> {
            try {
                storageService.save(file);
                messages.add(file.getOriginalFilename() + " [Successful]");
            } catch (Exception e) {
                messages.add(file.getOriginalFilename() + " <Failed> - " + e.getMessage());
            }
        });

        model.addAttribute("messages", messages);

        return "admin/upload_form";
    }

    @GetMapping("/files")
    public String getListFiles(Model model) {
        // Method implementation

        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FileController.class, "getFile", path.getFileName().toString()).build().toString();

            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        model.addAttribute("files", fileInfos);

        return "admin/files";
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/files/delete/{filename:.+}")
    public String deleteFile(@PathVariable String filename, Model model, RedirectAttributes redirectAttributes) {
        try {
            boolean existed = storageService.delete(filename);

            if (existed) {
                redirectAttributes.addFlashAttribute("message", "Delete the file successfully: " + filename);
            } else {
                redirectAttributes.addFlashAttribute("message", "The file does not exist!");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message",
                    "Could not delete the file: " + filename + ". Error: " + e.getMessage());
        }

        return "redirect:admin/files";
    }
}
*/