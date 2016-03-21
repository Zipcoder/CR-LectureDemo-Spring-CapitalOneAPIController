package Partayyy;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class Authenticate {

    @Autowired
    private AccountDatabase accountDatabase;

    private static Authenticate instance;

    private Authenticate(){};

    public static Authenticate getInstance(){
        if(instance == null){
            instance = new Authenticate();
        }
        return instance;
    }

    public boolean userDoesNotExist(String userName){
        ArrayList<UserAccount> accounts = (ArrayList<UserAccount>) accountDatabase.findByUserName(userName);

        for(UserAccount user:accounts){
            if(user.getUserName().equals(userName)){
                return false;
            }
        }
        return true;
    }

}
