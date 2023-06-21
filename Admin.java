public class Admin extends Account{
    private int id;
    private String username;
    private String password;
    private String email;
    private AccountType accountType;
    private double wallet;


    // Constructor
    public Admin(String username, String password, String email, double wallet) {
        super(username,password,AccountType.ADMIN);
        this.username = username;
        this.password = password;
        this.email = email;
        this.accountType = AccountType.ADMIN;
        this.wallet = wallet;

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

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for accountType
    public AccountType getAccountType() {
        return accountType;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
