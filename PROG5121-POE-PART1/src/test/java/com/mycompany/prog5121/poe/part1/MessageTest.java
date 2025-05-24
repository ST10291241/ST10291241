/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.prog5121.poe.part1;

import java.util.List;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mphom
 */
public class MessageTest {
    
    public MessageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUniqueMessageID method, of class Message.
     */
    @Test
    public void testGetUniqueMessageID() {
        System.out.println("getUniqueMessageID");
        Message instance = null;
        String expResult = "";
        String result = instance.getUniqueMessageID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumMessagesSent method, of class Message.
     */
    @Test
    public void testGetNumMessagesSent() {
        System.out.println("getNumMessagesSent");
        Message instance = null;
        int expResult = 0;
        int result = instance.getNumMessagesSent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecipient method, of class Message.
     */
    @Test
    public void testGetRecipient() {
        System.out.println("getRecipient");
        String recipientNumber = "+27718693002";
        String recipientNumber2 = "08575975889";

        Message instance = new Message(2);
        
        int expResult = 1;
        int expResult2 = 0;
        int result = instance.checkRecipientCell(recipientNumber);
        int result2 = instance.checkRecipientCell(recipientNumber2);

       
        assertEquals(expResult, result);
        assertEquals(expResult2,result2);
    }       
    

    /**
     * Test of getMessageContent method, of class Message.
     */
    @Test
    public void testGetMessageContent() {
        System.out.println("getMessageContent");
        Message instance = null;
        String expResult = "";
        String result = instance.getMessageContent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageHash method, of class Message.
     */
    @Test
    public void testGetMessageHash() {
        System.out.println("getMessageHash");
        Message instance = null;
        String expResult = "";
        String result = instance.getMessageHash();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRecipient method, of class Message.
     */
    @Test
    public void testSetRecipient() {
        System.out.println("setRecipient");
        String recipient = "";
        Message instance = null;
        instance.setRecipient(recipient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessageContent method, of class Message.
     */
    @Test
    public void testSetMessageContent() {
        System.out.println("setMessageContent");
        String messageContent = "";
        Message instance = null;
        instance.setMessageContent(messageContent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUniqueMessageIDForTest method, of class Message.
     */
    @Test
    public void testSetUniqueMessageIDForTest() {
        System.out.println("setUniqueMessageIDForTest");
        String id = "";
        Message instance = null;
        instance.setUniqueMessageIDForTest(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkMessageID method, of class Message.
     */
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        Message instance = null;
        boolean expResult = false;
        boolean result = instance.checkMessageID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        String recipientNumber = "+27718693002";
        String recipientNumber2 = "08575975889";

        Message instance = new Message(2);
        
        int expResult = 1;
        int expResult2 = 0;
        int result = instance.checkRecipientCell(recipientNumber);
        int result2 = instance.checkRecipientCell(recipientNumber2);

        if(result ==1){
        assertEquals(expResult, result);
        JOptionPane.showMessageDialog(null, "Cell phone number successfully captured", "Recipient CellPhone Number", JOptionPane.INFORMATION_MESSAGE);
        }else if(result2 ==0){
                    assertEquals(expResult2, result2);
                 JOptionPane.showMessageDialog(null, "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again", "Recipient CellPhone Number", JOptionPane.ERROR_MESSAGE);
   
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of createMessageHash method, of class Message.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        Message instance = null;
        String expResult = "";
        String result = instance.createMessageHash();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SentMessage method, of class Message.
     */
    @Test
    public void testSentMessage() {
        System.out.println("SentMessage");
        Message instance = null;
        String expResult = "";
        String result = instance.SentMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMessages method, of class Message.
     */
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        Message instance = null;
        String expResult = "";
        String result = instance.printMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeMessagesToJson method, of class Message.
     */
    @Test
    public void testStoreMessagesToJson() {
        System.out.println("storeMessagesToJson");
        List<Message> messages = null;
        Message.storeMessagesToJson(messages);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
