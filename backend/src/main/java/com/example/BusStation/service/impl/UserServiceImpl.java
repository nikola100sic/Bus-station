package com.example.BusStation.service.impl;


import com.example.BusStation.enumeration.UserRole;
import com.example.BusStation.exception.users.PasswordMismatchException;
import com.example.BusStation.model.User;
import com.example.BusStation.repository.UserRepository;
import com.example.BusStation.service.UserService;
import com.example.BusStation.web.dto.RegistrationDTO;
import com.example.BusStation.web.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User registration(RegistrationDTO registrationData) {
        if (!registrationData.getPassword().equals(registrationData.getRepeatedPassword())) {
            throw new PasswordMismatchException();
        } else {
            User user = new User();
            user.setName(registrationData.getName());
            user.setToken(UUID.randomUUID().toString());
            user.setSurname(registrationData.getSurname());
            user.setUsername(registrationData.getUsername());
            String encodedPassword = passwordEncoder.encode(registrationData.getPassword());
            user.setPassword(encodedPassword);
            user.setEMail(registrationData.getEMail());
            user.setUserRole(UserRole.USER);
            return userRepository.save(user);
        }
    }

    @Override
    public User update(UserDTO userDTO) {
        User existingUser = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found with ID: " + userDTO.getId()));
        existingUser.setName(userDTO.getName());
        existingUser.setSurname(userDTO.getSurname());
        existingUser.setUsername(userDTO.getUsername());
        existingUser.setEMail(userDTO.getEMail());
        existingUser.setUserRole(UserRole.USER);
        return userRepository.save(existingUser);
    }

    @Override
    public void verifyUser(User user) {
        user.setEmailVerified(true);
        userRepository.save(user);
    }

    @Override
    public User findByToken(String token) {
        return userRepository.findByToken(token).orElse(null);
    }

    @Override
    public boolean isVerified(User user) {
        return user.isEmailVerified();
    }

    @Override
    public User getOneUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public UserDTO getOneUserDto(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setUserRole(user.getUserRole());
        userDTO.setUsername(user.getUsername());
        userDTO.setEMail(user.getEMail());
        userDTO.setSurname(user.getSurname());
        return userDTO;
    }
}
