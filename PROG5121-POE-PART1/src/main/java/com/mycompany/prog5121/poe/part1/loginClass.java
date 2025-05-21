/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog5121.poe.part1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mphom
 */
public class loginClass {

    Scanner sc = new Scanner(System.in);
    //These are the attributes that are going to store the users information
    String username;
    String password;
    String firstName;
    String lastName;
    String PhoneNumber;

    public boolean checkUserName(String UserName) {
        boolean result1 = false;
        if (UserName.length() <= 5 && UserName.contains("_")) {
            System.out.println("Username successfully captured");
            result1 = true;
        } else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
            result1 = false;

            RegisterUser();
        }

        return result1;
    }

    //This is a code snippet from codevision modified.
    //https://codevisionz.com/lessons/java-code-example-simple-login/
    // Code Vision
    // Accessed at: 5 April 2025
    // Modified by Gemini Accessed at: https://gemini.google.com/app/77553c07975d7a2f
    // Accessed at: 5 April 2025
    public boolean checkPasswordComplexity(String Password) {

        boolean passwordLength = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        String specialCharacters = "!@#$%^&*()-+=<>?/{}[]|\\";

        if (Password.length() >= 8) {
            passwordLength = true;
        }
        //Used a for loop to go through all the characters in the password to see if there are any Captial letters, a number or a special case
        for (char c : Password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (specialCharacters.contains(String.valueOf(c))) {
                hasSpecialChar = true;
            }
        }
        if (!hasUpperCase || !hasDigit || !hasSpecialChar || !passwordLength) {
            System.out.println("***********************************************************");

            System.out.println("""
                               Password is not correctly formatted.
                               -Please ensure that the Password contains at least 8 characters
                                -A Capital Letter 
                                -A Number 
                                -A special character""");
            System.out.println("***********************************************************");

            hasDigit = false;
            hasUpperCase = false;
            passwordLength = false;
            hasSpecialChar = false;
            RegisterUser();
        } else {
            System.out.println("***********************************************************");
            System.out.println("Password successfully captured.");
            System.out.println("***********************************************************");

        }

        return hasDigit || hasUpperCase || passwordLength || hasSpecialChar;
    }

    public String RegisterUser() {
        System.out.println("Welcome to Registeration");

        System.out.println("Enter Username "
                + "\n*NB Username should contain an underscore\n"
                + "*Username should be no more than 5 characters long : ");
        username = sc.nextLine();
        System.out.println("***********************************************************");
        checkUserName(username);
        System.out.println("***********************************************************");
        System.out.println("Enter password \n"
                + "*NB Password should atleast contain 8 characters\n"
                + " *Password should contain a Capital letter\n"
                + "Password should contain a number\n"
                + "Password should contain a special character: ");
        password = sc.nextLine();
        System.out.println("***********************************************************");
        checkPasswordComplexity(password);
        System.out.println("***********************************************************");

        System.out.println("Enter phone number: \n"
                + "NB Phone number should contain a international code\n"
                + "Phone number should not be 10 digits long");
        PhoneNumber = sc.nextLine();
        System.out.println("***********************************************************");
        if (checkCellPhoneNumber(PhoneNumber)) {
            System.out.println("Cell phone number successfully added");
        } else {
            System.out.println("Cell phone number inccorrectly formatted, or does not contain a international code");
            System.out.println("***********************************************************");
            System.out.println("Enter phone number: \n"
                    + "NB Phone number should contain a international code\n"
                    + "Phone number should not be 10 digits long");
            PhoneNumber = sc.nextLine();
            if (checkCellPhoneNumber(PhoneNumber)) {
                System.out.println("***********************************************************");

                System.out.println("Cell phone number successfully added");
                System.out.println("***********************************************************");

            } else {
                System.out.println("Cell phone number inccorrectly formatted, or does not contain a international code");
                RegisterUser();
            }
        }
        System.out.println("***********************************************************");

        System.out.print("Enter First Name: ");
        firstName = sc.nextLine();
        System.out.println("***********************************************************");

        System.out.print("Enter Last Name: ");
        lastName = sc.nextLine();
        System.out.println("***********************************************************");

        loginUser(username, password);
        return returnLoginStatus(username, password);
    }

    /*OpenAI.(2025). ChatGPT (Mar 15 version) [Large language model]. https://chatgpt.com/c/67d5d29f-7eb8-800e-9717-fd5faee34e61
    Accessed (15 March 2025)*/
    public boolean checkCellPhoneNumber(String cellNumber) {
        boolean result = false;
        String regex = "^\\+\\d{1,3}\\d{1,10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cellNumber);

        return matcher.matches();
    }
    //This is the login method which verifies if the user is entering the correct details.

    public boolean loginUser(String Username, String Password) {
        boolean result3 = false;
        while (result3 == false) {
            System.out.println("Welcome to Login Page");
            System.out.print("Enter username: ");
            Username = sc.nextLine();
            System.out.println("***********************************************************");
            System.out.print("Enter Password: ");
            Password = sc.nextLine();
            System.out.println("***********************************************************");

            if (Username.equals(username) && Password.equals(password)) {
                System.out.println("Welcome " + firstName + ", " + lastName + " it is great to see you again");
                System.out.println("***********************************************************");

                result3 = true;
            } else {
                System.out.println("Username or Password incorrect, please try again");
                System.out.println("***********************************************************");

                result3 = false;
            }
        }
        return result3;
    }

    public String returnLoginStatus(String username, String password) {
        String Message;
        if (checkUserName(username) == true) {
            Message = "A successful login";
        } else {
            Message = "A failed Login";
        }
        return Message;

    }
}
