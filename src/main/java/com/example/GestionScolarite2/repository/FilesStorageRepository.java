package com.example.GestionScolarite2.repository;

import com.example.GestionScolarite2.entity.FileInfo;
import com.example.GestionScolarite2.entity.classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilesStorageRepository extends JpaRepository<FileInfo, Long> {

    @Query("SELECT f FROM FileInfo f JOIN FETCH f.classe")
    List<FileInfo> findAllWithClasse();}
