package PCard.Controllers;
import PCard.Domain.AccountDatabase;
import PCard.Domain.Authenticate;
import PCard.Domain.UserAccount;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class AccountCreationController {
    @RequestMapping(value = "newuser",method = RequestMethod.POST)
    public UserAccount createUser(@RequestParam Map<String,String> requestParams) throws Exception{
        String email=requestParams.get("email");
        String password=requestParams.get("password");
        String username=requestParams.get("username");
        String accountnumber=requestParams.get("accountnumber");
        String monthlybudget=requestParams.get("monthlybudget");
        String partynightsperweek=requestParams.get("partynightsperweek");

        //perform DB operations
        Authenticate authenticator = Authenticate.getInstance();
        if (authenticator.authUsername(username)&&authenticator.authEmail(email)&&authenticator.authPassword(password)
                &&authenticator.isDouble(monthlybudget)&&authenticator.isInteger(partynightsperweek)){
            UserAccount userToAdd = new UserAccount(username,email,password,monthlybudget,partynightsperweek,accountnumber);
            AccountDatabase.addUserToDB(userToAdd);
            return userToAdd;
        }

        else {
            return new UserAccount("error");
        }
    }
}
