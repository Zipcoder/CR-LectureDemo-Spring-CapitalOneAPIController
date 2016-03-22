package PCard.Domain;

import org.springframework.data.repository.CrudRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountDatabase {
    private static ArrayList<UserAccount> userAccounts = new ArrayList<UserAccount>();

    AccountDatabase() throws IOException {
        userAccounts.add(UserAccount.createAccount("Dorinda", "pass1", "email@mail.com", "56c66be5a73e492741507437"));
        userAccounts.add(UserAccount.createAccount("Isabella", "pass2", "mail@email.com", "56c66be5a73e492741507437"));
    }

    public static void addUserToDB(UserAccount userToAdd){
        userAccounts.add(userToAdd);
    }

    public static ArrayList<UserAccount> getUserAccounts(){
        return userAccounts;
    }

}
