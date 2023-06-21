import java.util.ArrayList;
import java.util.List;
public class Shop {
    private String name;
    private String webAddress;
    private String supportPhoneNumber;
    private List<Account> AdminAccounts;
    private List<Account> UserAccounts;
    public List<Product> products;
    public Admin mainAdmin = new Admin("mainAdmin","01234","admin@gmail.com",0);
    public List<Product> books;
    public List<Product> clothes;
    public List<Product> electronics;

    private List<Order> orders;
    private double totalProfit;
    private double wallet;
    public Cart cart;
    public User currentUser;
    public Account currentAdmin;
    //private static Shop instance;

    public Shop(String name, String webAddress, String supportPhoneNumber) {
        this.name = name;
        this.webAddress = webAddress;
        this.supportPhoneNumber = supportPhoneNumber;
        this.UserAccounts= new ArrayList<>();
        this.AdminAccounts = new ArrayList<>();
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.books = new ArrayList<Product>();
        this.clothes = new ArrayList<>();
        this.electronics = new ArrayList<>();
        this.cart = new Cart();
        this.totalProfit = 0.0;
        this.wallet = 0.0;

    }

    // Getter and setter methods

    public List<Account> getAdminAccounts() {
        return AdminAccounts;
    }
    public List<Account> getUserAccounts(){
        return UserAccounts;
    }

    public void setAccounts(Account acc) {
        if(acc.getAccountType().equals(AccountType.USER)){
            UserAccounts.add(acc);
        }
        else {
            AdminAccounts.add(acc);
        }
    }

    public void getProducts() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
    }

    public void setProducts(Product product) {
        products.add(product);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(Order order) {
        orders.add(order);
    }

    public double getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(double totalProfit) {
        this.totalProfit = totalProfit;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    // Method to add funds to the shop's wallet
    public void addToWallet(double amount) {
        wallet += amount;
    }

    public List<Product> searchBookProducts(String keyword) {
        List<Product> searchResults = new ArrayList<>();

        for (Product books1 : books) {
            if (books1.getName().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(books1);
            }
        }
        for (int i = 0; i < searchResults.size(); i++) {
            System.out.println(searchResults.get(i));
        }
        return searchResults;
    }
    public List<Product> searchClotheProducts(String keyword) {
        List<Product> searchResults = new ArrayList<>();

        for (Product clothe1: clothes) {
            if (clothe1.getName().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(clothe1);
            }
        }
        for (int i = 0; i < searchResults.size(); i++) {
            System.out.println(searchResults.get(i));
        }
        return searchResults;
    }
    public List<Product> searchElecProducts(String keyword) {
        List<Product> searchResults = new ArrayList<>();

        for (Product elec1 : electronics) {
            if (elec1.getName().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(elec1);
            }
        }
        for (int i = 0; i < searchResults.size(); i++) {
            System.out.println(searchResults.get(i));
        }
        return searchResults;
    }

}
