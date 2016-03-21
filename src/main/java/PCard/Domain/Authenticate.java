package PCard.Domain;

import java.util.ArrayList;

public class Authenticate {
    public static boolean authenticate(String userName){
        ArrayList<UserAccount> accounts = AccountDatabase.getUserAccounts();

        for(UserAccount user:accounts){
            if(user.getUserName().equals(userName)){
                return false;
            }
        }
        return true;
    }

}
