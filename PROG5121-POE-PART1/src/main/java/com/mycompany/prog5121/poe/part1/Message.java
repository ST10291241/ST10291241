/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog5121.poe.part1;

import java.util.Random;
import java.util.Scanner; // Still needed for SentMessage if not using JOptionPane for options
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane; // Added for SentMessage if it were to use JOptionPane

public class Message {
    private String uniqueMessageID;
    private int numMessagesSent; // This will be set by the main app and represents the current message's sequential number
    private String recipient;
    private String messageContent;
    private String messageHash;

    // Constructor
    public Message(int currentMessageNumber) {
        this.numMessagesSent = currentMessageNumber;
        this.uniqueMessageID = generateUniqueMessageID();
    }

    // --- Getters ---
    public String getUniqueMessageID() {
        return uniqueMessageID;
    }

    public int getNumMessagesSent() {
        return numMessagesSent;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public String getMessageHash() {
        return messageHash;
    }

    // --- Setters ---
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    // Added for testing purposes to set a specific ID for predictable hash tests
    // Made package-private to limit access
    void setUniqueMessageIDForTest(String id) {
        this.uniqueMessageID = id;
    }

    // --- Methods as per rubric ---

    /**
     * Generates a random 10-digit number for the unique message ID.
     * @return A 10-digit string representing the unique message ID.
     */
    
    // Code Snippet
    // By GeeksforGeeks, 24 April 2025, Generating random numbers in java, Available at :https://www.geeksforgeeks.org/generating-random-numbers-in-java/ ,[Accessed 24 May 2025]
    private String generateUniqueMessageID() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10)); // Append a random digit (0-9)
        }
        return sb.toString();
    }

    /**
     * This method ensures that the message ID is not more than ten characters.
     * Since we generate a 10-character ID, this effectively checks if it's 10.
     * 
     */
    public boolean checkMessageID() {
     return this.uniqueMessageID != null && this.uniqueMessageID.length() == 10;
    }

    /**
     * This method ensures that the recipient cell number is no more than ten characters long
     * and starts with an international code (e.g., "+").
     
     */
    public int checkRecipientCell(String recipientNumber) {
        // Regex for a common international phone number format:
        // Starts with '+' followed by 1 to 3 digits (country code)
        // Then 7 to 15 digits (local number). This is a more realistic validation.
        String regex = "^\\+[0-9]{1,3}[0-9]{7,15}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(recipientNumber);

        if (matcher.matches()) {
            return 1; 
        }
        return 0; 
    }

    /**
     * This method creates and returns the Message Hash.
     * Format: first two numbers of the message ID:0:number of the message:first and last words in the message (ALL CAPS).
     * 
     */
    
    // 
    public String createMessageHash() {
        if (uniqueMessageID == null || messageContent == null || messageContent.trim().isEmpty()) {
            return "ERROR: Missing data for hash generation.";
        }

        String idPrefix = uniqueMessageID.substring(0, 2);
        String[] words = messageContent.trim().split("\\s+"); // Split by one or more spaces

        String firstWord = "";
        String lastWord = "";

        if (words.length > 0) {
            firstWord = words[0];
            if (words.length > 1) {
                lastWord = words[words.length - 1];
            } else {
                lastWord = firstWord; // If only one word, first and last are the same
            }
        }

        this.messageHash = String.format("%s:%d:%s%s",
                idPrefix,
                numMessagesSent,
                firstWord.toUpperCase(),
                lastWord.toUpperCase());
        return this.messageHash;
    }

    /**
     * This method should allow the user to choose if they want to send, store, or disregard the message.
     * @return A string indicating the user's choice: "SEND", "STORE", or "DISCARD".
     */
    public String SentMessage() {
      //  Object[] options = {"Send Message", "Disregard Message", "Store Message to send later"};
        int choice = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "Message completed. Choose an option:"+
                        "\n1) Send Message"+
                        "\n2) Disregard Message"+
                        "\n3) Store Message to send later"
                
        ));

                /*        if (choice == 1) {
                } else if (choice == 2) {
                    JOptionPane.showMessageDialog(null, "Coming Soon.", "Feature Status", JOptionPane.INFORMATION_MESSAGE);
                    i--;
                } else if (choice == 3) {
                    running = false;
                    JOptionPane.showMessageDialog(null, "Exiting QuickChat. Goodbye!", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please choose from the options.", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }*/
        
            if (choice == 1) {
           // case JOptionPane.YES_OPTION: // Corresponds to "Send Message"
                return "SEND";
        }else if (choice == 2) {
           // case JOptionPane.NO_OPTION: // Corresponds to "Disregard Message"
                return "DISCARD";
        }else if (choice == 3) {
            //case JOptionPane.CANCEL_OPTION: // Corresponds to "Store Message to send later"
                return "STORE";
        }else{//default:
                // This case should ideally not be reached with showOptionDialog with default option selected.
                return "DISCARD"; // Default to discard on unexpected close
        }
    }
    

    /**
     * This method returns a formatted string of the message details.
     * @return A formatted string containing MessageID, Message Hash, Recipient, Message.
     */
    public String printMessages() {
        return String.format("Message ID: %s\nMessage Hash: %s\nRecipient: %s\nMessage: %s",
                uniqueMessageID, messageHash, recipient, messageContent);
    }

    
    
    
    // ChatGpt, 24 May 2025, Availible at :https://chatgpt.com/c/6831cb31-b69c-8001-b132-0c430c976c51 
    public static void storeMessagesToJson(List<Message> messages) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("messages.json");
        try {
            // Write the list of messages to the JSON file
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, messages);
            System.out.println("Messages stored to messages.json successfully.");
        } catch (IOException e) {
            System.err.println("Error storing messages to JSON: " + e.getMessage());
        }
    }
}