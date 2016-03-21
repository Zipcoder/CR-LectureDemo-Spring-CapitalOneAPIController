package Partayyy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping(value = "newuser")
    public UserAccount createUser(@RequestParam Map<String,String> requestParams) throws Exception{
        String email=requestParams.get("email");
        String password=requestParams.get("password");
        String username = requestParams.get("username");
        //perform DB operations
        boolean nameAvail = Authenticate.getInstance().userDoesNotExist(username);
        if (nameAvail){
            UserAccount userToAdd = new UserAccount(username,email,password);
            accountDatabase.save(userToAdd);
            return userToAdd;
        }
        else {
            return new UserAccount("error");
        }
    }


}
