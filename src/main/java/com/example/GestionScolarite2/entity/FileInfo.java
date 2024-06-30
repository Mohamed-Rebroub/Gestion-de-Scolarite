package com.example.GestionScolarite2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "FileInfo")
public class FileInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_EDT;

  private String name;
  private String url;

  @ManyToOne
  @JoinColumn(name = "id_classe")
  private classe classe;

  public FileInfo(String name, String url, classe classe) {
    this.name = name;
    this.url = url;
    this.classe = classe;
  }

  public FileInfo() {}

  // Getters and setters (if not using Lombok's @Data)
}
