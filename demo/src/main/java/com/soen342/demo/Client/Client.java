package com.soen342.demo.Client;

import com.soen342.demo.ServiceInterfaces.ClientService;
import com.soen342.demo.dto.ClientDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Client {
    private int age;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String guardianPhoneNumber;

    private final ClientService clientService;

    @Autowired
    public Client(ClientService clientService) {
        this.clientService = clientService;
    }


    public Client(){
        this.clientService = null;
    }

    // Constructor if client is over age, no need for guardian phone number
    public Client(int age, String firstName, String lastName, String phoneNumber, String password) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.guardianPhoneNumber = null;
        this.clientService = null;

    }
    // Constructor if client is under age need for guardian phone number
    public Client(int age, String firstName, String lastName, String phoneNumber, String password,
            String guardianPhoneNumber) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.guardianPhoneNumber = guardianPhoneNumber;
        this.clientService = null;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getGuardianPhoneNumber() {
        return guardianPhoneNumber;
    }
    public void setGuardianPhoneNumber(String guardianPhoneNumber) {
        this.guardianPhoneNumber = guardianPhoneNumber;
    }
    public boolean IsClientUnderage(Client client) {
        if (client.getAge() < 18)
            return true;
        else
            return false;
    }
    @Override
    public String toString() {
        StringBuilder nameString = new StringBuilder(firstName + " " + lastName);
        if (IsClientUnderage(this))
            return nameString.toString() +
                    ", age " + age +
                    ", whose phone number is " + phoneNumber + ", and their gaurdian's phone number is "
                    + guardianPhoneNumber;
        else
            return nameString.toString() +
                    ", age " + age +
                    ", whose phone number is " + phoneNumber;
    }

     public void createClientToDB(int age, String firstName, String lastName, String phoneNumber, String password, String guardianPhoneNumber) {
        ClientDto clientDto = new ClientDto();
        clientDto.setClient_id((int) (Math.random() * 10000));
        clientDto.setAge(age);
        clientDto.setFirstName(firstName);
        clientDto.setLastName(lastName);
        clientDto.setPhoneNumber(phoneNumber);
        clientDto.setPassword(password);
        clientDto.setGuardianPhoneNumber(guardianPhoneNumber);

        clientService.createClient(clientDto);
    }

    public static void main(String[] args) {
        Client tester = new Client(40, "testing", "tester", "5141234567", "40000000", "1234567");
        System.out.println(tester.toString());
    }
}