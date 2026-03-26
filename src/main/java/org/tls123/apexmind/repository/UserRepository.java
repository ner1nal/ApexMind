package org.tls123.apexmind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tls123.apexmind.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
