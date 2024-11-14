package com.soen342.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private int client_id;
    private int age;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String guardianPhoneNumber;
}
