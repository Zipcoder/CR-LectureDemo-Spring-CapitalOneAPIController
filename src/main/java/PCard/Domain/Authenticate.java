package PCard.Domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Authenticate {

    @Autowired
    private AccountDatabase accountDatabase;

    private static Authenticate instance;

    private Authenticate(AccountDatabase accountDatabase){
        this.accountDatabase = accountDatabase;
    }

    private Authenticate() {}

    public static Authenticate getInstance(AccountDatabase accountDatabase){
        if(instance == null){
            instance = new Authenticate(accountDatabase);
        }
        return instance;
    }

    public boolean authenticate(String userName, String password){
        UserAccount user = accountDatabase.findByUserName(userName);

        if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
            return true;

        }
        return false;
    }
    public boolean authUsername(String userName) {
        if (userName == null) {
            return false;
        }

        if (userName.matches("^[\\w]{6,15}")) {
            return accountDatabase.findByUserName(userName) == null;
        }
        else return false;
    }

    public boolean authEmail(String email) {
        if (email == null) {
            return false;
        }

        if (email.matches("[A-Za-z_0-9.%+-]{1,50}@[A-Za-z0-9.-]{1,50}\\.[a-zA-Z]{2,3}")) {
            UserAccount account = accountDatabase.findByEmail(email);
            return account == null;
        }
        else return false;
    }

    public boolean authPassword(String password) {
        if (password == null) {
            return false;
        }
        if (password.matches("^[\\w]{6,20}")) {
            return true;
        }
        else return false;
    }

    public boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}
