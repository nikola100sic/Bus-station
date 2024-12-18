package com.example.BusStation.web.dto;

import com.example.BusStation.enumeration.UserRole;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    private String username;

    private String name;

    private String token;

    private String surname;

    private String eMail;

    private UserRole userRole;

    private boolean isVerified;
}
