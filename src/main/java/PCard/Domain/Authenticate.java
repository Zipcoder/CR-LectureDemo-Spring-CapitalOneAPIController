package PCard.Domain;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;

public class Authenticate {

    @Autowired
    private static AccountDatabase accountDatabase;

    private static Authenticate instance;

    private Authenticate(){};

    public static Authenticate getInstance(){
        if(instance == null){
            instance = new Authenticate();
        }
        return instance;
    }

    public static boolean authenticate(String userName, String password){
        ArrayList<UserAccount> accounts = (ArrayList<UserAccount>) accountDatabase.findByUserName(userName);

        for(UserAccount user:accounts) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    public static boolean authUsername(String userName) {
        if (userName == null) {
            return false;
        }

        if (userName.matches("^[\\w]{6,15}")) {
            ArrayList<UserAccount> accounts = (ArrayList<UserAccount>) accountDatabase.findByUserName(userName);
            return accounts.isEmpty();
        }
        else return false;
    }

    public static boolean authEmail(String email) {
        if (email == null) {
            return false;
        }

        if (email.matches("[A-Za-z_0-9.%+-]{1,50}@[A-Za-z0-9.-]{1,50}\\.[a-zA-Z]{2,3}")) {
            ArrayList<UserAccount> accounts = (ArrayList<UserAccount>) accountDatabase.findByEmail(email);
            return accounts.isEmpty();
        }
        else return false;
    }

    public static boolean authPassword(String password) {
        if (password == null) {
            return false;
        }
        if (password.matches("^[\\w]{6,20}")) {
            return true;
        }
        else return false;
    }

    public static boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}
