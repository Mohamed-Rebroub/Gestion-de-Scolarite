package com.example.GestionScolarite2.service;

import com.example.GestionScolarite2.entity.FileInfo;
import com.example.GestionScolarite2.entity.classe;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public interface FilesStorageService {
  void init();


  Resource load(String filename);

   List<FileInfo> loadAllWithClasse() ;


  boolean delete(String filename);

  Stream<Path> loadAll();

  void save(MultipartFile file, classe classe);
}
