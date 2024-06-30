package com.example.GestionScolarite2.service;
import com.example.GestionScolarite2.entity.Absence;
import com.example.GestionScolarite2.entity.FileInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface AbsenceService {



    public Absence createAbsence(Absence absence);

    public List<Absence> getAbsenceByUserId(Long id);
    public Absence getAbsenceById(Long id);
    public List<Absence> loadAllWithUser();

    public Absence updateAbsence(Long id, Absence updatedAbsence) ;

    public void deleteAbsence(Long id);


    public List<Absence> getAllAbsences() ;
}
