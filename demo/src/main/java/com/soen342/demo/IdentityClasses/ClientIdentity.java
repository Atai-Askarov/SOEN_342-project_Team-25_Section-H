package com.soen342.demo.IdentityClasses;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class ClientIdentity {
    @Id
    @Column(name = "client_id") 
    private int client_id;

    @Column(name = "age") 
    private int age;

    @Column(name = "first_name") 
    private String firstName;

    @Column(name = "last_name") 
    private String lastName;

    @Column(name = "phone_number") 
    private String phoneNumber;

    @Column(name = "guardian_phone_number") 
    private String guardianPhoneNumber;

    @Column(name = "password_") 
    private String password;
}
