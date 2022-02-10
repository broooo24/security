package com.example.demo.service.databaseseeder;

import com.example.demo.domain.entity.RoleEntity;
import com.example.demo.domain.entity.UserEntity;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeederService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    public void seeding() {
        RoleEntity adminRole = new RoleEntity();
        RoleEntity userRole = new RoleEntity();
        RoleEntity contentManagerRole = new RoleEntity();
        adminRole.setName("Administrator");
        userRole.setName("User");
        contentManagerRole.setName("ContentManager");

        //saving the roles
        adminRole = roleRepository.save(adminRole);
        userRole = roleRepository.save(userRole);
        contentManagerRole = roleRepository.save(contentManagerRole);

        UserEntity adminUser = new UserEntity();
        UserEntity user1User = new UserEntity();
        UserEntity user2User = new UserEntity();
        UserEntity user3User = new UserEntity();

        List<RoleEntity> adminRoles = new ArrayList<>();
        adminRoles.add(adminRole);
        List<RoleEntity> user1Roles = new ArrayList<>();
        user1Roles.add(userRole);
        user1Roles.add(contentManagerRole);
        List<RoleEntity> user2Roles = new ArrayList<>();
        user2Roles.add(contentManagerRole);
        List<RoleEntity> user3Roles = new ArrayList<>();
        user3Roles.add(userRole);

        adminUser.setRoleEntities(adminRoles);
        user1User.setRoleEntities(user1Roles);
        user2User.setRoleEntities(user2Roles);
        user3User.setRoleEntities(user3Roles);

        adminUser.setUsername("Admin");
        user1User.setUsername("User1");
        user2User.setUsername("User2");
        user3User.setUsername("User3");

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        adminUser.setPassword(passwordEncoder.encode("1234"));
        user1User.setPassword(passwordEncoder.encode("4321"));
        user2User.setPassword(passwordEncoder.encode("1111"));
        user3User.setPassword(passwordEncoder.encode("2222"));

        userRepository.save(adminUser);
        userRepository.save(user1User);
        userRepository.save(user2User);
        userRepository.save(user3User);
        System.out.println("seeding completed!");
    }
}
