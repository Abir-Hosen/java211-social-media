package com.abir.project.service;

import com.abir.project.modal.User;

public interface UserService {
	
	public User save(User user);
	public User findById(Long id);

}
