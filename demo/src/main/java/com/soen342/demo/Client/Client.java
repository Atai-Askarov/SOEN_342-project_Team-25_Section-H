package com.soen342.demo.Client;

import com.soen342.demo.Console.ClientConsole;
import com.soen342.demo.IdentityClasses.ClientIdentity;
import com.soen342.demo.RepositoryClasses.ClientRepository;
import com.soen342.demo.ServiceInterfaces.BookingService;
import com.soen342.demo.ServiceInterfaces.ClientService;
import com.soen342.demo.ServiceInterfaces.LessonService;
import com.soen342.demo.ServiceInterfaces.OfferingService;
import com.soen342.demo.ServiceInterfaces.OfferingService;
import com.soen342.demo.dto.BookingDto;
import com.soen342.demo.dto.ClientDto;
import com.soen342.demo.dto.LessonDto;
import com.soen342.demo.dto.OfferingDto;

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
    private final ClientRepository clientRepository;
    private final OfferingService offeringService;
    private final LessonService lessonService;
    private final BookingService bookingService;  // Add BookingService

    @Autowired
    public Client(ClientService clientService, ClientRepository clientRepository, 
                OfferingService offeringService, LessonService lessonService, 
                BookingService bookingService) {  // Include BookingService in constructor
        this.clientService = clientService;
        this.clientRepository = clientRepository;
        this.offeringService = offeringService;
        this.lessonService = lessonService;
        this.bookingService = bookingService;  // Initialize BookingService
    }

    public Client() {
        this.clientService = null;
        this.clientRepository = null;
        this.offeringService = null;
        this.lessonService = null;
        this.bookingService = null;  // Initialize BookingService as null
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
        this.offeringService = null;
        this.clientRepository = null;
        this.lessonService = null;
        this.bookingService = null;  // Initialize BookingService as null
    }

    // Constructor if client is under age, needs guardian phone number
    public Client(int age, String firstName, String lastName, String phoneNumber, String password,
                String guardianPhoneNumber) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.guardianPhoneNumber = guardianPhoneNumber;
        this.clientService = null;
        this.offeringService = null;
        this.clientRepository = null;
        this.lessonService = null;
        this.bookingService = null;  // Initialize BookingService as null
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

    public boolean login(String phoneNumber, String password) {
        ClientIdentity client = clientRepository.findByPhoneNumber(phoneNumber);
        if (client != null && client.getPassword().equals(password)) {
            System.out.println("Login successful for client: " + client.getFirstName() + " " + client.getLastName());
            ClientConsole.currentClientId = client.getClient_id();
            return true;
        } else {
            System.out.println("Login failed. Incorrect phone number or password.");
            return false;
        }
    }

    public void viewAllOfferings() {
        try {
            List<OfferingDto> offerings = offeringService.getAllOfferings();
            if (offerings.isEmpty()) {
                System.out.println("No offerings available.");
            } else {
                offerings.forEach(offering -> {
                    System.out.println("Offering ID: " + offering.getOfferingId());
                    System.out.println("Lesson ID: " + offering.getLessonId());
                    System.out.println("Instructor ID: " + offering.getInstructorId());

                    LessonDto lesson = lessonService.getLessonById(offering.getLessonId());
                    System.out.println("Lesson Name: " + lesson.getLessonName());
                    System.out.println("Capacity: " + lesson.getCapacity());
                    System.out.println("---------------------------------");
                });
            }
        } catch (Exception e) {
            System.err.println("Error retrieving offerings: " + e.getMessage());
        }
    }

    public void acceptOffering(Scanner scanner, int clientId) {
        try {
            System.out.print("Enter the Offering ID you want to accept: ");
            int offeringId = scanner.nextInt();

            OfferingDto offering = offeringService.getOfferingById(offeringId);
            if (offering == null) {
                System.out.println("Offering not found.");
                return;
            }

            BookingDto booking = new BookingDto();
            booking.setOfferingId(offeringId);
            booking.setClientId(clientId);
            booking.setAvailability(true);

            BookingDto createdBooking = bookingService.createBooking(booking);

            System.out.println("Booking successfully created for Offering ID: " + offeringId);
            System.out.println("Booking ID: " + createdBooking.getBookingId());

        } catch (Exception e) {
            System.err.println("Error accepting offering: " + e.getMessage());
        }
    }
    public void viewOwnBookings(int clientId) {
        try {
            List<BookingDto> bookings = bookingService.getBookingsByClientId(clientId);
    
            if (bookings.isEmpty()) {
                System.out.println("No bookings found for this client.");
            } else {
                System.out.println("Bookings for Client ID: " + clientId);
                for (BookingDto booking : bookings) {
                    System.out.println("Booking ID: " + booking.getBookingId());
                    System.out.println("Offering ID: " + booking.getOfferingId());
                    System.out.println("---------------------------------");
                }
            }
        } catch (Exception e) {
            System.err.println("Error retrieving bookings: " + e.getMessage());
        }
    }

    public void cancelBooking(Scanner scanner) {
        try {
            System.out.print("Please enter the booking ID you want to cancel: ");
            int bookingId = scanner.nextInt();

            bookingService.cancelBooking(bookingId);
            System.out.println("Booking with ID " + bookingId + " has been successfully cancelled.");
        } catch (Exception e) {
            System.err.println("Error cancelling booking: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Client tester = new Client(40, "testing", "tester", "5141234567", "40000000", "1234567");
        System.out.println(tester.toString());
    }
}