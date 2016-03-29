package PCard.Domain;
import javax.persistence.*;

@Entity
@Table(name="users")
public class UserAccount {
    private double balance, monthlyBudget;
    private int partyNights;
    private String userName,password,email,accountNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    protected UserAccount(){}

    public UserAccount(String userName, String email, String password, String monthlyBudget, String partyNights, String accountNumber) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.monthlyBudget = Double.parseDouble(monthlyBudget);
        this.partyNights = Integer.parseInt(partyNights);
        this.accountNumber = accountNumber;
    }

    public UserAccount(String userName){
        this.userName=userName;
    }

    public double getMonthlyBudget() {return monthlyBudget;}

    public void setMonthlyBudget(double monthlyBudget) {this.monthlyBudget = monthlyBudget;}

    public void setEmail(String email) {this.email = email;}

    public String getAccountNumber() {return accountNumber;}

    public void setAccountNumber(String accountNumber) {this.accountNumber = accountNumber;}

    public int getPartyNights() {return partyNights;}

    public void setPartyNights(int partyNights) {this.partyNights = partyNights;}

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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

    public long getId(){return this.id;}

    @Override
    public String toString() {
        return String.format(
                "UserAccount[id=%d, userName='%s', email='%s', accountNumber='%s']",
                id, userName, email, accountNumber);
    }
}
