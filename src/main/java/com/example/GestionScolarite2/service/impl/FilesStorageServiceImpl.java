package com.example.GestionScolarite2.service.impl;

import com.example.GestionScolarite2.entity.FileInfo;
import com.example.GestionScolarite2.entity.classe;
import com.example.GestionScolarite2.repository.FilesStorageRepository;
import com.example.GestionScolarite2.service.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {
  private final Path root = Paths.get("./uploads");

  @Autowired
  private FilesStorageRepository fileInfoRepository;

  @Override
  public void init() {
    try {
      Files.createDirectories(root);
    } catch (IOException e) {
      throw new RuntimeException("Could not initialize folder for upload!");
    }
  }



  @Override
  public void save(MultipartFile file, classe classe) {
    try {
      Path destinationFile = this.root.resolve(file.getOriginalFilename());
      Files.copy(file.getInputStream(), destinationFile);
      // Sauvegarder les informations du fichier dans la base de données
      FileInfo fileInfo = new FileInfo(file.getOriginalFilename(), destinationFile.toString(), classe);
      fileInfoRepository.save(fileInfo);
    } catch (Exception e) {
      if (e instanceof FileAlreadyExistsException) {
        throw new RuntimeException("Filename already exists.");
      }
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override
  public Resource load(String filename) {
    try {
      Path file = root.resolve(filename);
      Resource resource = new UrlResource(file.toUri());

      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new RuntimeException("Could not read the file!");
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException("Error: " + e.getMessage());
    }
  }

  @Override
  public List<FileInfo> loadAllWithClasse() {
    return fileInfoRepository.findAllWithClasse();
  }

  @Override
  public boolean delete(String filename) {
    try {
      Path file = root.resolve(filename);
      return Files.deleteIfExists(file);
    } catch (IOException e) {
      throw new RuntimeException("Error: " + e.getMessage());
    }
  }

  /*@Override
  public void deleteAll() {
    FileSystemUtils.deleteRecursively(root.toFile());
  }*/

  @Override
  public Stream<Path> loadAll() {
    try {
      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
    } catch (IOException e) {
      throw new RuntimeException("Could not load the files!");
    }
  }
}
