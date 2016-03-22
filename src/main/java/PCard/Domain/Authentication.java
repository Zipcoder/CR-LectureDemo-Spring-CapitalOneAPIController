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

    private static Authentication instance;

    public static Authentication getInstance(){
        if(instance == null){
            instance = new Authentication();
        }
        return instance;
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


    public static boolean authEmail(String email) {
        if (email==null){
            return false;
        }
        //REPLACE THIS BIT WITH DB LOOKUP METHOD
        ArrayList<UserAccount> accounts = AccountDatabase.getUserAccounts();
        if (accounts.contains(email)) {
            return false;
        }

        if (email.matches("[A-Za-z_0-9.%+-]{1,50}@[A-Za-z0-9.-]{1,50}\\.[a-zA-Z]{2,3}")) {
            return true;
        }
        return false;
    }

    public static boolean authPassword(String password) {
        if (password==null){
            return false;
        }
        if (password.matches("^[\\w]{6,20}")) {
            return true;
        }
        return false;
    }

    public static boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException|NullPointerException e) {
            return false;
        }
        return true;
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException|NullPointerException e) {
            return false;
        }
        return true;
    }
}
