import java.util.ArrayList;
import java.util.List;
public class User extends Account {
    private int id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;
    private double wallet;
    private List<Order> orders;
    public AccountType accountType;


    // Constructor
    public User(String username, String password, String email, String phoneNumber, String address, double wallet) {
        super(username,password,AccountType.USER);
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.wallet = wallet;
        this.orders = new ArrayList<>();
        accountType = AccountType.USER;

    }

    // Getter and Setter methods for username, password, email, phoneNumber, address, and wallet

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void addOrder(Order order) {
        orders.add(order);
    }
}
