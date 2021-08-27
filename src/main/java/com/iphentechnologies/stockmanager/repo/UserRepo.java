package com.iphentechnologies.stockmanager.repo;

import com.iphentechnologies.stockmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,String> {

    @Query(value = "SELECT * FROM User WHERE user_email=?1", nativeQuery = true)
    User getUser(String email);

    boolean existsByUserEmail(String userEmail);
}
