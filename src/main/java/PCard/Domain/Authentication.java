package PCard.Domain;

import java.util.ArrayList;

public class Authentication {
    public static boolean authenticate(String userName, String password){
        ArrayList<UserAccount> accounts = AccountDatabase.getUserAccounts();

        for(UserAccount user:accounts) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
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
    public static boolean emailAvailable(String email){
        ArrayList<UserAccount> accounts = AccountDatabase.getUserAccounts();

        for(UserAccount user:accounts) {
            if (user.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }
}
