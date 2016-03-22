package PCard.Domain;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by rkelly on 3/21/16.
 */
public class AccountDatabaseTest {

    static UserAccount user;
    @BeforeClass
    public static void setup() throws IOException {
        user = UserAccount.createAccount("Drury", "pass3","bob@email.com", "56c66be6a73e492741507f89");
    }

    @Test
    public void testAddUserToDB() throws Exception {
        AccountDatabase.addUserToDB(user);
        assertEquals("Drury", AccountDatabase.getUserAccounts().get(0).getUserName());
    }

    @Test
    public void testGetUserAccounts() throws Exception {
        //Forced to test in testAddUserToDB
    }
}