package com.aleksey.spring_boot_33.__todo_application.repositories;

import com.aleksey.spring_boot_33.__todo_application.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository used to store user accounts
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
