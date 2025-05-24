/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.prog5121.poe.part1;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mphom
 */
public class PROG5121POEPART1 {

    private static List<Message> sentMessages = new ArrayList<>();
    private static int totalMessagesSentCounter = 0; // Tracks successfully sent/stored messages

    public static void main(String[] args) {
         loginClass obj1 = new loginClass();
         obj1.RegisterUser();
        boolean loggedIn = true; // Assume logged in successfully for now, as per rubric point 1.
        boolean running = true;

        if (loggedIn) {
            JOptionPane.showMessageDialog(null, "Welcome to QuickChat.", "Welcome", JOptionPane.INFORMATION_MESSAGE);

            int numberOfMessagesToEnter = 0;
            String numMessagesStr = JOptionPane.showInputDialog(null, "How many messages do you wish to enter?", "Message Count", JOptionPane.QUESTION_MESSAGE);
            if (numMessagesStr != null && !numMessagesStr.trim().isEmpty()) {
                try {
                    numberOfMessagesToEnter = Integer.parseInt(numMessagesStr);
                    if (numberOfMessagesToEnter <= 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a positive number of messages. Exiting.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Exit if invalid number
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number. Exiting.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Exit if not a number
                }
            } else {
                JOptionPane.showMessageDialog(null, "No number of messages entered. Exiting.", "Information", JOptionPane.INFORMATION_MESSAGE);
                return; // Exit if dialog cancelled or empty
            }

            // Loop to allow user to enter the assigned number of messages
            for (int i = 0; i < numberOfMessagesToEnter; i++) {
                // If user decides to quit mid-way, break the loop
                if (!running) {
                    break;
                }

                // Display menu and get choice using JOptionPane
                //  Object[] options = {"Send Messages", "Show recently sent messages (Coming Soon)", "Quit"};
                int choice = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                          QuickChat
                                                                          1) Send Messages
                                                                          2) Show recently sent messages
                                                                          3) Quit"""));

                if (choice == 1) {
                    processSendMessage();
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
                }

                /* switch (choice) {
                    case 0: // "Send Messages"
                        processSendMessage();
                        break;
                    case 1: // "Show recently sent messages (Coming Soon)"
                        JOptionPane.showMessageDialog(null, "Coming Soon.", "Feature Status", JOptionPane.INFORMATION_MESSAGE);
                        i--; // Decrement i to allow user to try sending message again or another option if this was a "skip"
                        break;
                    case 2: // "Quit"
                    case JOptionPane.CLOSED_OPTION: // Handle dialog closed by user
                        running = false;
                        JOptionPane.showMessageDialog(null, "Exiting QuickChat. Goodbye!", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        // This should ideally not be reached with showOptionDialog for fixed options
                        JOptionPane.showMessageDialog(null, "Invalid choice. Please choose from the options.", "Error", JOptionPane.ERROR_MESSAGE);
                        i--; // Decrement i to allow user to try again
                        break;
                }*/
            }

            // After the for loop, if not quit already, display total messages.
            if (running) { // Only if not explicitly quit during the loop
                JOptionPane.showMessageDialog(null, "You have entered the set number of messages.\nTotal messages sent/stored: " + totalMessagesSentCounter, "QuickChat Summary", JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "You must be logged in to use QuickChat.", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void processSendMessage() {
        totalMessagesSentCounter++; // Increment totalMessagesSentCounter immediately to represent current message number
        Message currentMessage = new Message(totalMessagesSentCounter); // Pass the sequence number

        // Recipient input and validation
        String recipient;
        while (true) {
            recipient = JOptionPane.showInputDialog(null, "Enter recipient cell number (e.g., +27123456789):", "Recipient", JOptionPane.QUESTION_MESSAGE);
            if (recipient == null) { // User cancelled
                JOptionPane.showMessageDialog(null, "Message entry cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                totalMessagesSentCounter--; // Decrement if cancelled
                return;
            }
            if (currentMessage.checkRecipientCell(recipient) == 1) {
                currentMessage.setRecipient(recipient);
                JOptionPane.showMessageDialog(null, "Cell phone number successfully captured.", "Success", JOptionPane.INFORMATION_MESSAGE);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Message content input and validation
        String message;
        while (true) {
            message = JOptionPane.showInputDialog(null, "Enter your message (max 250 characters):", "Message Content", JOptionPane.QUESTION_MESSAGE);
            if (message == null) { // User cancelled
                JOptionPane.showMessageDialog(null, "Message entry cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                totalMessagesSentCounter--; // Decrement if cancelled
                return;
            }
            if (message.length() <= 250) { //
                currentMessage.setMessageContent(message);
                JOptionPane.showMessageDialog(null, "Message ready to send.", "Success", JOptionPane.INFORMATION_MESSAGE);
                break;
            } else {
                int excessChars = message.length() - 250;
                // Note: The rubric specified "Please enter a message of less than 50 characters." but the limit is 250 characters.
                // I'm using the 250 char limit. If the error message must strictly say 50, then this needs adjustment.
                JOptionPane.showMessageDialog(null, "Message exceeds 250 characters by " + excessChars + ", please reduce size.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Generate Message Hash
        currentMessage.createMessageHash();
        JOptionPane.showMessageDialog(null, "Generated Message Hash: " + currentMessage.getMessageHash(), "Hash Generated", JOptionPane.INFORMATION_MESSAGE);

        // Ask user what to do with the message (Send, Discard, Store) using JOptionPane
        String action = currentMessage.SentMessage();

        if(action.equals("SEND")){
        sentMessages.add(currentMessage);
                JOptionPane.showMessageDialog(null, currentMessage.printMessages(), "Message Details", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Message successfully sent.", "Status", JOptionPane.INFORMATION_MESSAGE);
        }else if (action.equals("DISCARD")){
            totalMessagesSentCounter--; // Decrement as it's not a valid 'sent' or 'stored' message for the count
                JOptionPane.showMessageDialog(null, "Press 0 to delete message. (Message discarded)", "Discarded", JOptionPane.INFORMATION_MESSAGE);
        }else if(action.equals("STORE")){
            sentMessages.add(currentMessage); // Add to the list to be stored
                Message.storeMessagesToJson(sentMessages); // Use the static method
                JOptionPane.showMessageDialog(null, "Message successfully stored.", "Status", JOptionPane.INFORMATION_MESSAGE);
        }
       /* switch (action) {
            case "SEND":
                sentMessages.add(currentMessage);
                JOptionPane.showMessageDialog(null, currentMessage.printMessages(), "Message Details", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Message successfully sent.", "Status", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "DISCARD":
                totalMessagesSentCounter--; // Decrement as it's not a valid 'sent' or 'stored' message for the count
                JOptionPane.showMessageDialog(null, "Press 0 to delete message. (Message discarded)", "Discarded", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "STORE":
                sentMessages.add(currentMessage); // Add to the list to be stored
                Message.storeMessagesToJson(sentMessages); // Use the static method
                JOptionPane.showMessageDialog(null, "Message successfully stored.", "Status", JOptionPane.INFORMATION_MESSAGE);
                break;
        }*/

        JOptionPane.showMessageDialog(null, "Total messages sent so far is: " + totalMessagesSentCounter, "Message Count", JOptionPane.INFORMATION_MESSAGE);
    }
}
