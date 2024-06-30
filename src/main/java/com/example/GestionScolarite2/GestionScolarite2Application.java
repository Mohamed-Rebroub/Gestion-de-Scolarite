package com.example.GestionScolarite2;

import com.example.GestionScolarite2.service.FilesStorageService;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.GestionScolarite2.entity")

public class GestionScolarite2Application implements CommandLineRunner {

	@Resource
	FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(GestionScolarite2Application.class, args);
	}
	@Override
	public void run(String... arg) throws Exception {
//    storageService.deleteAll();
		storageService.init();
	}
}

