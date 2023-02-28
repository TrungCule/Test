package com.example.TEST.repository;

import com.example.TEST.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID>, UserRepositoryCustom {
    @Query(value = "select * from Users where username = ?1", nativeQuery = true)
    Users findByUserName(String username);
}
