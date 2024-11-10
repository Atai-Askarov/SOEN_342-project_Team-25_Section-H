package Client;

import java.math.BigInteger;

public class Client {
    private int age;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String guardianPhoneNumber;

    public Client() {
    }

    // Constructor if client is over age, no need for guardian phone number
    public Client(int age, String firstName, String lastName, String phoneNumber, String password) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.guardianPhoneNumber = null;
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

    public static void main(String[] args) {
        Client tester = new Client(40, "testing", "tester", "5141234567", "40000000", "1234567");
        System.out.println(tester.toString());
    }
}
