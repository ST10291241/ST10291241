/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.prog5121.poe.part1;

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
public class loginClassTest {
    
    public loginClassTest() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
    
    

    /**
     * Test of checkUserName method, of class loginClass.
     */
    @org.junit.Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String UserName = "kyl_1";
        loginClass instance = new loginClass();
        boolean expResult = true;
        boolean result = instance.checkUserName(UserName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
        
    }

    /**
     * Test of checkPasswordComplexity method, of class loginClass.
     */
    @org.junit.Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String Password = "Ch&&sec@ke99!";
        loginClass instance = new loginClass();
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity(Password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    

    /**
     * Test of checkCellPhoneNumber method, of class loginClass.
     */
    @org.junit.Test
    public void testCheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        String cellNumber = "+27838968974";
        loginClass instance = new loginClass();
        boolean expResult = true;
        boolean result = instance.checkCellPhoneNumber(cellNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of loginUser method, of class loginClass.
     */
    @org.junit.Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String Username = "kyl_1";
        String Password = "Ch&&sec@ke99!";
        loginClass instance = new loginClass();
        boolean expResult = true;
        boolean result = instance.loginUser(Username, Password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of returnLoginStatus method, of class loginClass.
     */
    @org.junit.Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        loginClass instance = new loginClass();
        String expResult = "A successful login";
        String result = instance.returnLoginStatus(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
