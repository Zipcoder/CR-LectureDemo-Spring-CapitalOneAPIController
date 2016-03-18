package PCard.Domain;

public class UserAccount {
    private double balance;
    private String userID, accountID,userName,password,email;
    private boolean authenticated = false;

    public UserAccount(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
    public UserAccount(String userName){
        this.userName=userName;
    }

    public double getBalance() {
        return balance;
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



}
