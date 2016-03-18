package PCard;

import java.util.ArrayList;

public class Authentication {
    public static boolean authenticate(String userName, String password){
        ArrayList<UserAccount> accounts = AccountDatabase.getUserAccounts();

        for(UserAccount user:accounts) {
            if (user.getUserName().equals(userName)) {
                return false;
            } else if (user.getPassword().equals(password)) {
                return false;
            }
        }
        return true;
    }

    public static boolean nameAvailable(String userName){
        ArrayList<UserAccount> accounts = AccountDatabase.getUserAccounts();

        for(UserAccount user:accounts) {
            if (user.getUserName().equals(userName)) {
                return false;
            }
        }
        return true;
    }
}
