package PCard.Controllers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rkelly on 3/18/16.
 */
public class CapitalOneAPIControllerTest {

    @Test
    public void testCheckAccount() throws Exception {
        String result = "{\"_id\":\"56c66be6a73e492741507f86\",\"rewards\":39435,\"balance\":37855,\"customer_id\":\"56c66be5a73e492741507437\",\"nickname\":\"Dorinda's Account\",\"type\":\"Checking\"}";
        assertEquals(result, CapitalOneAPIController.checkAccount("56c66be6a73e492741507f86"));
    }

    @Test
    public void testCheckBalance() throws Exception {

    }

}