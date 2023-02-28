package com.example.TEST.service.impl;

import com.example.TEST.domain.CustomUserDetails;
import com.example.TEST.domain.Roles;
import com.example.TEST.domain.Users;
import com.example.TEST.repository.RolesRepository;
import com.example.TEST.repository.UserRepository;
import com.example.TEST.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);
    private final RolesRepository rolesRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(RolesRepository rolesRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.rolesRepository = rolesRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users users = userRepository.findByUserName(userName);
        if(users == null){
            log.info("user not found in databases");
            throw new UsernameNotFoundException("user not found in databases");
        } else {
            log.info("User found in databases {}",users.getUsername());
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        users.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });
        return CustomUserDetails.builder().users(users).build();
    }

    @Override
    public Users saveUser(Users users) {
        log.info("Saving new user to databases: " + users.getUsername());
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return userRepository.save(users);
    }

    @Override
    public Roles saveRole(Roles roles) {
        log.info("Saving new role to databases: " + roles.getRoleName());
        return rolesRepository.save(roles);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        log.info("Add role{} for user{}: ", userName, roleName);
        Users user = userRepository.findByUserName(userName);
        Roles role = rolesRepository.findByRoleName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public Users getUser(String userName) {
        log.info("Fetching user {} ", userName);
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<Users> getUsers() {
        log.info("Fetching all user");
        return userRepository.findAll();
    }
    @Transactional
    public UserDetails loadUserById(UUID id) {
        Users users = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );
        return CustomUserDetails.builder().users(users).build();
    }
//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        // Kiểm tra xem user có tồn tại trong database không?
//        Users users = userRepository.findByUsername(username);
//        CustomUserDetails a = CustomUserDetails.builder().users(users).build();
//        if (users == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new CustomUserDetails(users);
//    }
}
