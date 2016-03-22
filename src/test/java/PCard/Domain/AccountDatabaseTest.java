package PCard.Domain;

import org.junit.BeforeClass;
import org.junit.Test;

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
        user = accountCreationController.userAccount("Drury");
    }

    @Test
    public void testAddUserToDB() throws Exception {
        assertEquals("Drury", accountDatabase.findByUserName("Drury").get(0).getUserName());
    }

}