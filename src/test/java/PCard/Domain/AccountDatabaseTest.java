package PCard.Domain;

import PCard.Controllers.AccountCreationController;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by rkelly on 3/21/16.
 */
public class AccountDatabaseTest {
    @Autowired
    AccountDatabase accountDatabase;

    static UserAccount user;
    @BeforeClass
    public static void setup() throws IOException {
        AccountCreationController accountCreationController = new AccountCreationController();
        //user = accountCreationController.createUser();
    }

    @Test
    public void testAddUserToDB() throws Exception {
        assertEquals("Drury", accountDatabase.findByUserName("Drury").get(0).getUserName());
    }

}