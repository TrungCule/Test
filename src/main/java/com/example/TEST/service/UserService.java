package com.example.TEST.service;

import com.example.TEST.domain.CustomUserDetails;
import com.example.TEST.domain.Roles;
import com.example.TEST.domain.Users;
import com.example.TEST.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public interface UserService extends UserDetailsService{

    UserDetails loadUserByUsername(String username);
    UserDetails loadUserById(UUID id);

    Users saveUser(Users users);
    Roles saveRole(Roles roles);

    void addRoleToUser(String userName, String roleName);
    Users getUser(String userName);
    List<Users> getUsers();
}
