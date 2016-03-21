package PCard.Domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class AccountCreationController {

    @Autowired
    AccountDatabase accountDatabase;

    @RequestMapping("/createaccountOne")
    public UserAccount userAccount(@RequestParam(value = "accountname", defaultValue = "ERROR") String accountname) {
        boolean nameAvail = Authenticate.getInstance().authUsername(accountname);
        if (nameAvail) {
            UserAccount userToAdd = new UserAccount(accountname);
            accountDatabase.save(userToAdd);
            return userToAdd;
        } else {
            return new UserAccount("error");
        }
    }

    @RequestMapping(value = "newuser", method = RequestMethod.POST)
    public UserAccount createUser(@RequestParam Map<String, String> requestParams) throws Exception {
        String email = requestParams.get("email");
        String password = requestParams.get("password");
        String username = requestParams.get("username");
        String accountnumber = requestParams.get("accountnumber");
        String monthlybudget = requestParams.get("monthlybudget");
        String partynightsperweek = requestParams.get("partynightsperweek");
        Authenticate authenticate = Authenticate.getInstance();

        //perform DB operations
        boolean nameAvail = authenticate.authUsername(username);
        if (nameAvail) {
            if (authenticate.authUsername(username) && authenticate.authEmail(email) && authenticate.authPassword(password)
                    && authenticate.isDouble(monthlybudget) && authenticate.isInteger(partynightsperweek)) {
                UserAccount userToAdd = new UserAccount(username, email, password);
                accountDatabase.save(userToAdd);
                return userToAdd;
            }
        }
        return new UserAccount("error");

    }
}
