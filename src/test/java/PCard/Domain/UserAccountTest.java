package PCard.Domain;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by rkelly on 3/18/16.
 */
public class UserAccountTest {

    static UserAccount user;

    @BeforeClass
    public static void setup() throws IOException {
        user = UserAccount.createAccount("Drury", "pass3","bob@email.com", "56c66be6a73e492741507f89");
    }

    @Before
    public void testAuthenticateUser() throws Exception {
        user.authenticateUser(user.getUserName(),user.getPassword());
        assertEquals(true,user.checkAuthentication());
    }

    @Test
    public void testCheckBalance() throws Exception {
        assertEquals((long)0,user.checkBalance(),0);
    }

    @Before
    public void testSetUserID() throws Exception {
        user.setUserID("1234");
    }

    @Test
    public void testSetBalance() throws Exception {
        user.setBalance(52);
        assertEquals(52.0,user.checkBalance(),0);
    }

    @Test
    public void testGetUserID() throws Exception {
        assertEquals("1234",user.getUserID());
    }

    @Before
    public void testSetAccountID() throws Exception {
        user.setAccountID("234892");
    }

    @Test
    public void testGetAccountID() throws Exception {
        assertEquals("234892",user.getAccountID());
    }

    @Before
    public void testSetUserName() throws Exception {
        user.setUserName("Bill");
    }

    @Test
    public void testGetUserName() throws Exception {
        assertEquals("Bill",user.getUserName());
    }


    @Test
    public void testGetEmail() throws Exception {
        assertEquals("bob@email.com",user.getEmail());
    }

    @Before
    public void testSetPassword() throws Exception {
        user.setPassword("pass2");
    }

    @Test
    public void testGetPassword() throws Exception {
        assertEquals("pass2",user.getPassword());
    }



}