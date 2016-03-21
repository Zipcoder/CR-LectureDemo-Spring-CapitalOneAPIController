import org.springframework.beans.factory.annotation.Autowired;
package PCard.Domain;
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

    @Autowired
    AccountDatabase accountDatabase;

    @RequestMapping("/createaccountOne")
    public UserAccount userAccount(@RequestParam(value="accountname", defaultValue="ERROR") String accountname) {
        boolean nameAvail = Authenticate.getInstance().userDoesNotExist(accountname);
        if (nameAvail){
            UserAccount userToAdd = new UserAccount(accountname);
            accountDatabase.save(userToAdd);
            return userToAdd;
        }
        else{
            return new UserAccount("error");
        }
    }
    @RequestMapping(value = "newuser",method = RequestMethod.POST)
    public UserAccount createUser(@RequestParam Map<String,String> requestParams) throws Exception{
        String email=requestParams.get("email");
        String password=requestParams.get("password");
        String username=requestParams.get("username");
        String accountnumber=requestParams.get("accountnumber");
        String monthlybudget=requestParams.get("monthlybudget");
        String partynightsperweek=requestParams.get("partynightsperweek");

        //perform DB operations
        boolean nameAvail = Authenticate.getInstance().userDoesNotExist(username);
        if (nameAvail){
        if (Authenticate.authUsername(username)&&Authenticate.authEmail(email)&&Authenticate.authPassword(password)
                &&Authenticate.isDouble(monthlybudget)&&Authenticate.isInteger(partynightsperweek)){
            UserAccount userToAdd = new UserAccount(username,email,password);
            accountDatabase.save(userToAdd);
            return userToAdd;
        }

        else {
            return new UserAccount("error");
        }
    }


}
