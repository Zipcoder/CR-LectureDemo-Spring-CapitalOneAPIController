package PCard.Domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserAccount {
    double balance;
    private String userID, accountID,userName,password,email;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    protected UserAccount(){}

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

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
                "UserAccount[id=%d, firstName='%s', lastName='%s']",
                id, userName, email);
    }
}
