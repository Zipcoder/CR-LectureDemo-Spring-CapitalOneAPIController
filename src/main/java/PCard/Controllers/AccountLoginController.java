package PCard.Controllers;

import PCard.Domain.Authenticate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by rkelly on 3/22/16.
 */

@ComponentScan
@RestController
public class AccountLoginController {

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public boolean createUser(@RequestParam Map<String,String> requestParams) throws Exception{
        String password=requestParams.get("password");
        String username=requestParams.get("username");

        return Authenticate.authenticate(username,password);
    }
}
