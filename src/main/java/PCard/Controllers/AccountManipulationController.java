package PCard.Controllers;

import PCard.Domain.AccountDatabase;
import PCard.Domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by rkelly on 3/22/16.
 */

@ComponentScan
@RestController
public class AccountManipulationController {

    @Autowired
    private static AccountDatabase accountDatabase;

    @RequestMapping("/getmonthlybudget")
    @ResponseBody
    public static String getBudget(@RequestParam Map<String,String> requestParams) throws Exception {
        String userid = requestParams.get("userid");
        ArrayList<UserAccount> accounts = (ArrayList<UserAccount>) accountDatabase.findByUserName(userid);
        for(UserAccount user:accounts) {
            if (user.checkAuthentication()) {
                return String.valueOf(user.checkBudget());
            }
        }
        return null;
    }

    @RequestMapping("/setbudget")
    @ResponseBody
    public static boolean setBudget(@RequestParam Map<String,String> requestParams) throws Exception {
        String userid = requestParams.get("userid");
        String budget = requestParams.get("budget");
        ArrayList<UserAccount> accounts = (ArrayList<UserAccount>) accountDatabase.findByUserName(userid);
        for(UserAccount user:accounts) {
            if (user.checkAuthentication()) {
                user.setMonthlyBudget(Double.valueOf(budget));
                return true;
            }
        }
        return false;
    }

    @RequestMapping("/setemail")
    @ResponseBody
    public static String setEmail(@RequestParam Map<String,String> requestParams) throws Exception {
        String userid = requestParams.get("userid");
        String email = requestParams.get("email");
        String cemail = requestParams.get("cemail");
        ArrayList<UserAccount> accounts = (ArrayList<UserAccount>) accountDatabase.findByUserName(userid);
        for(UserAccount user:accounts) {
            if (user.checkAuthentication()) {
                if (email.equals(cemail)) {
                    user.setEmail(email);
                    return "success";
                }
                return "error";
            }
        }
        return "fail";
    }

    @RequestMapping("/getemail")
    @ResponseBody
    public static String getEmail(@RequestParam Map<String,String> requestParams) throws Exception {
        String userid = requestParams.get("userid");
        ArrayList<UserAccount> accounts = (ArrayList<UserAccount>) accountDatabase.findByUserName(userid);
        for(UserAccount user:accounts) {
            if (user.checkAuthentication()) {
                return user.getEmail();
            }
        }
        return null;
    }

    @RequestMapping("/getpartynights")
    @ResponseBody
    public static String getNights(@RequestParam Map<String,String> requestParams) throws Exception {
        String userid = requestParams.get("userid");
        ArrayList<UserAccount> accounts = (ArrayList<UserAccount>) accountDatabase.findByUserName(userid);
        for(UserAccount user:accounts) {
            if (user.checkAuthentication()) {
                return String.valueOf(user.getPartyNights());
            }
        }
        return null;
    }

    @RequestMapping("/setpartynights")
    @ResponseBody
    public static boolean setNights(@RequestParam Map<String,String> requestParams) throws Exception {
        String userid = requestParams.get("userid");
        String nights = requestParams.get("nights");
        ArrayList<UserAccount> accounts = (ArrayList<UserAccount>) accountDatabase.findByUserName(userid);
        for(UserAccount user:accounts) {
            if (user.checkAuthentication()) {
                user.setPartyNights(Integer.valueOf(nights));
                return true;
            }
        }
        return false;
    }

    @RequestMapping("/setbalance")
    @ResponseBody
    public static boolean setBalance(@RequestParam Map<String,String> requestParams) throws Exception {
        String userid = requestParams.get("userid");
        String balance = requestParams.get("balance");
        ArrayList<UserAccount> accounts = (ArrayList<UserAccount>) accountDatabase.findByUserName(userid);
        for(UserAccount user:accounts) {
            if (user.checkAuthentication()) {
                user.setBalance(Double.valueOf(balance));
                return true;
            }
        }
        return false;
    }

    @RequestMapping("/setaccountid")
    @ResponseBody
    public static boolean setAccountID(@RequestParam Map<String,String> requestParams) throws Exception {
        String userid = requestParams.get("userid");
        String id = requestParams.get("id");
        ArrayList<UserAccount> accounts = (ArrayList<UserAccount>) accountDatabase.findByUserName(userid);
        for(UserAccount user:accounts) {
            if (user.checkAuthentication()) {
                user.setAccountID(id);
                return true;
            }
        }
        return false;
    }

    @RequestMapping("/setpassword")
    @ResponseBody
    public static String setPassword(@RequestParam Map<String,String> requestParams) throws Exception {
        String password = requestParams.get("password");
        String cpassword = requestParams.get("cpassword");
        String userid = requestParams.get("userid");
        ArrayList<UserAccount> accounts = (ArrayList<UserAccount>) accountDatabase.findByUserName(userid);
        for(UserAccount user:accounts) {
            if (user.checkAuthentication()) {
                if (password.equals(cpassword)) {
                    return "success";
                }
                return "error";
            }
        }
        return "fail";
    }
}
