package com.example.TEST.repository;

import com.example.TEST.domain.Roles;
import com.example.TEST.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RolesRepository extends JpaRepository<Roles, UUID>, RolesRepositoryCustom {
    @Query(value = "select * from Roles where roleName = ?1", nativeQuery = true)
    Roles findByRoleName(String username);
}
