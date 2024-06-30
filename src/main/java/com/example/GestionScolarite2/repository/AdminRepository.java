package com.example.GestionScolarite2.repository;

import com.example.GestionScolarite2.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByEmailAndPassword(String email, String password);
    Admin findByEmail(String email);


}
