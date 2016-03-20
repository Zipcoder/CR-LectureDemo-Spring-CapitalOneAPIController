package Partayyy;
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

        //perform DB operations
        if (Authenticate.authUsername(username)&&Authenticate.authEmail(email)&&Authenticate.authPassword(password)){
            UserAccount userToAdd = new UserAccount(username,email,password);
            AccountDatabase.addUserToDB(userToAdd);
            return userToAdd;
        }

        else {
            return new UserAccount("error");
        }
    }
}
