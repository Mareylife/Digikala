import java.util.ArrayList;
import java.util.List;

public class Seller extends Account {
    private int id;
    private String companyName;
    private String password;
    private List<Product> availableProducts;
    private double wallet;
    private AccountType accountType;
    private List<Order> orders;


    // Constructor
    public Seller(String companyName, String password) {
        super(companyName,password,AccountType.SELLER);
        this.companyName = companyName;
        this.password = password;
        this.availableProducts = new ArrayList<>();
        this.wallet = 0.0;
        this.accountType = AccountType.SELLER;
        this.orders = new ArrayList<>();

    }

    // Getter for companyName
    public String getCompanyName() {
        return companyName;
    }

    // Setter for companyName
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for availableProducts
    public List<Product> getAvailableProducts() {
        return availableProducts;
    }

    // Method to add a new product to the available products list
    public void addProduct(Product product) {
        availableProducts.add(product);
    }

    // Getter for wallet
    public double getWallet() {
        return wallet;
    }

    // Setter for wallet
    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setAvailableProducts(List<Product> availableProducts) {
        this.availableProducts = availableProducts;
    }

    // Getter for accountType
    public AccountType getAccountType() {
        return accountType;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void addOrder(Order order) {
        orders.add(order);
    }
}
