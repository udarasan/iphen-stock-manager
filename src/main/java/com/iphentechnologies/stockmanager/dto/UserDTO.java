package com.iphentechnologies.stockmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private long userID;
    private String userEmail;
    private String userPassword;
    private String userRole;
}
