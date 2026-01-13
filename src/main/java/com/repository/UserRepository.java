package com.patternpath.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.patternpath.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
