package com.example.GestionScolarite2.repository;

import com.example.GestionScolarite2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
    @Query(value = "select * from users where email = ?1", nativeQuery = true)
    Optional<User> findByEmail(String email);


    //   User findByEmaill(String email);
}
