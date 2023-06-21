import java.util.List;

public class Account {
    private String username;
    private String password;
    private AccountType accountType;

    // Constructor
    public Account(String username, String password, AccountType accountType) {
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for accountType
    public AccountType getAccountType() {
        return accountType;
    }

    // Setter for accountType
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
