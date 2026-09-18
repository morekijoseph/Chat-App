package chatapp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChatAppTest {

    private Login login;

    public ChatAppTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // Initialize the Login object before each test
        login = new Login();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCheckUserName_Valid() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testCheckUserName_Invalid_NoUnderscore() {
        assertFalse(login.checkUserName("kyle1"));
    }

    @Test
    public void testCheckUserName_Invalid_TooLong() {
        assertFalse(login.checkUserName("kyle_123"));
    }

    @Test
        
    public void testCheckPasswordComplexity_Invalid_NoUppercase() {
              assertFalse(login.checkPasswordComplexity("ch&&se9!"));
    }
    

    @Test
    public void testCheckPasswordComplexity_Invalid_TooShort() {
        assertFalse(login.checkPasswordComplexity("Ch&&se9!"));
    }

    @Test
    public void testCheckPasswordComplexity_Invalid_NoSpecialChar() {
        assertFalse(login.checkPasswordComplexity("Password123"));
    }

    @Test
    public void testCheckPasswordComplexity_Invalid_NoDigit() {
        assertFalse(login.checkPasswordComplexity("Password@!"));
    }

    @Test
    public void testCellphoneNumber_Valid() {
        assertTrue(login.CellphoneNumber("+27831234567"));
    }

    @Test
    public void testCellphoneNumber_Invalid_NoPlus() {
        assertFalse(login.CellphoneNumber("0831234567"));
    }

    @Test
    public void testCellphoneNumber_Invalid_TooShort() {
        assertFalse(login.CellphoneNumber("+2783123"));
    }
    
    @Test
    public void testCellphoneNumber_EmptyString() {
        assertTrue(login.CellphoneNumber(""));
    }

    @Test
    public void testLoginUser_Success() {
        String storedUsername = "kyl_1";
        String storedPassword = "Ch&&sec@ke99!";
        String enteredUsername = "kyl_1";
        String enteredPassword = "Ch&&sec@ke99!";
        
        assertTrue(login.loginUser(storedUsername, storedPassword, enteredUsername, enteredPassword));
    }

    @Test
    public void testLoginUser_Fail_WrongPassword() {
        String storedUsername = "kyl_1";
        String storedPassword = "Ch&&sec@ke99!";
        String enteredUsername = "kyl_1";
        String enteredPassword = "WrongPassword1!";
        
        assertFalse(login.loginUser(storedUsername, storedPassword, enteredUsername, enteredPassword));
    }

    @Test
    public void testReturnLoginStatus_Success() {
        // Create a new Login object with actual names
        Login loginWithNames = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27831234567");
        
        String expected = "Welcome Kyle Smith, it is great to see you again!";
        String actual = loginWithNames.returnLoginStatus(true);
        
        assertEquals(expected, actual);
    }

    @Test
    public void testReturnLoginStatus_Fail() {
        String expected = "Username or password incorrect, please try again.";
        String actual = login.returnLoginStatus(false);
        
        assertEquals(expected, actual);
    }
}