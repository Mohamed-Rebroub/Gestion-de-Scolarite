package com.example.GestionScolarite2.service;

import com.example.GestionScolarite2.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserService {
	List<User> getAllUsers();
	
	List<User> getUsersByPagination(int pageNo, int pageSize);
	
	Integer getUsersCount();
	
	User getUserById(Long id);
	Optional<User> getUserByEmail(String email);
	User saveUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(Long id);

	String uploadImage(MultipartFile image) throws IOException;
	
	String updateImage(String oldImageName, MultipartFile image) throws IOException;
	
	String encryptPassword(String password);
	
	
}
