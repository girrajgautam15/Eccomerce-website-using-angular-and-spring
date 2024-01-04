package com.Eccomerce.backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Eccomerce.backend.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);

}
