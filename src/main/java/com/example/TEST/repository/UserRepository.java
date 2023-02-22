package com.example.TEST.repository;

import com.example.TEST.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>, UserRepositoryCustom {
    @Query(value = "select * from User where username = ?1", nativeQuery = true)
    User findByUsername(String username);
}
