package PCard;

import java.util.ArrayList;

public class AccountDatabase {
    private static ArrayList<UserAccount> userAccounts = new ArrayList<UserAccount>();
    AccountDatabase(){
        userAccounts.add(new UserAccount("jimbob"));
        userAccounts.add(new UserAccount("joe"));
    }

    public static void addUserToDB(UserAccount userToAdd){
        userAccounts.add(userToAdd);
    }

    public static ArrayList<UserAccount> getUserAccounts(){
        return userAccounts;
    }

}
