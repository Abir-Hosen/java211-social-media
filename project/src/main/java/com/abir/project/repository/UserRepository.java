package com.abir.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abir.project.modal.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

}
