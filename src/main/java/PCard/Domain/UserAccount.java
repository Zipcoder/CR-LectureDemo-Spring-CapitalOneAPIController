package PCard.Domain;

import PCard.Controllers.CapitalOneAPIController;
import org.apache.catalina.User;

import java.io.IOException;

public class UserAccount {
    private double balance;
    private String userID, accountID,userName,password,email;
    private boolean authenticated = false;


    private UserAccount(String userName, String password, String email, String accountID) throws IOException{
            this.userName = userName;
            this.email = email;
            this.password = password;
            this.balance = CapitalOneAPIController.checkBalance(accountID);
            AccountDatabase.addUserToDB(this);
    }

    public static UserAccount createAccount(String userName, String password, String email, String accountID) throws IOException {
        if (Authentication.nameAvailable(userName) && Authentication.emailAvailable(email)) {
            return new UserAccount(userName, password, email, accountID);
        }
        return null;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void authenticateUser(String userName, String password) {
        authenticated = Authentication.authenticate(userName,password);
    }
    public boolean checkAuthentication() {
        return authenticated;
    }
    public double checkBalance() throws IOException {
        return this.balance;
    }
}
