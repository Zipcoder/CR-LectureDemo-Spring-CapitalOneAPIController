package Partayyy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AccountCreationController {
    @RequestMapping("/createaccountOne")
    public UserAccount userAccount(@RequestParam(value="accountname", defaultValue="ERROR") String accountname) {
        boolean nameAvail = Authenticate.authenticate(accountname);
        if (nameAvail){
            UserAccount userToAdd = new UserAccount(accountname);
            AccountDatabase.addUserToDB(userToAdd);
            return userToAdd;
        }
        else{
            return new UserAccount("error");
        }
    }
    @RequestMapping(value = "newuser")
    public UserAccount createUser(@RequestParam Map<String,String> requestParams) throws Exception{
        String email=requestParams.get("email");
        String password=requestParams.get("password");
        String username = requestParams.get("username");
        //perform DB operations
        boolean nameAvail = Authenticate.authenticate(username);
        if (nameAvail){
            UserAccount userToAdd = new UserAccount(username,email,password);
            AccountDatabase.addUserToDB(userToAdd);
            return userToAdd;
        }
        else {
            return new UserAccount("error");
        }
    }


}
