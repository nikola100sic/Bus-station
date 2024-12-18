package com.example.BusStation.service;


import com.example.BusStation.model.User;
import com.example.BusStation.web.dto.RegistrationDTO;
import com.example.BusStation.web.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User registration(RegistrationDTO registrationData);

    User update(UserDTO updateData);

    void verifyUser(User user);

    User findByToken(String token);

    boolean isVerified(User user);

    User getOneUser(String username);

    UserDTO getOneUserDto(String username);

}
