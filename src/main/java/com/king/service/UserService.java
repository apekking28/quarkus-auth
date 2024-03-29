package com.king.service;

import com.king.dto.request.UserRequestDTO;
import com.king.model.User;
import com.king.repository.RoleRepository;
import com.king.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    @Inject
    RoleRepository roleRepository;

    @Transactional
    public User addUser(UserRequestDTO request) {
        User addUser = new User();
        addUser.setName(request.getName());
        addUser.setEmail(request.getEmail());
        addUser.setPassword(request.getPassword());
        addUser.addRole(roleRepository.findById(1L));

        userRepository.persist(addUser);
        return addUser;
    }

    public List<User> listAllUsers() {
        return userRepository.findAll().stream().toList();
    }

    @Transactional
    public User updateUser(Long userId, UserRequestDTO request) {
        User existingUser = userRepository.findByIdOptional(userId)
                .orElseThrow(() -> new IllegalArgumentException("User with id " + userId + " not found"));


        existingUser.setName(request.getName());
        existingUser.setEmail(request.getEmail());

        return existingUser;
    }

    public String deleteUser(Long userId) {
        User existingUser = userRepository.findByIdOptional(userId)
                .orElseThrow(() -> new IllegalArgumentException("User with id " + userId + " not found"));

        userRepository.delete(existingUser);

        return "Successfully delete User with id " + userId;
    }
}
