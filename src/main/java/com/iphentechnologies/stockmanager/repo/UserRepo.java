package com.iphentechnologies.stockmanager.repo;

import com.iphentechnologies.stockmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,String> {
    @Query(value = "SELECT password FROM User WHERE email=?1", nativeQuery = true)
    String getPassword(String email);
}
