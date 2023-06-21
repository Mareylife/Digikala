import java.util.ArrayList;
import java.util.List;
public class Product {
    private String name;
    private double price;
    //private int stock;
    private int quantity;
    private int purchasedQuantity;
    private List<String> comments;
    private Seller company;
    // additional data based on product type and category

    public Product(String name, double price, int quantity, Seller company) {
        this.name = name;
        this.price = price;
        //this.stock = stock;
        this.purchasedQuantity = 1;
        this.quantity = quantity;
        this.comments = new ArrayList<>();
        this.company = company;
        // initialize additional data
    }

    @Override
    public String toString() {
        return "Product name: " + getName() + ", with price: " + getPrice() +
                ", with the quantity: " + getQuantity() + ", And the seller company is : " + getCompany().getCompanyName();
    }
    // Getter and setter methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getQuantity() {
        return quantity;
    }

    // Setter for quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPurchasedQuantity() {
        return purchasedQuantity;
    }

    public void setPurchasedQuantity(int purchasedQuantity) {
        this.purchasedQuantity = purchasedQuantity;
    }

    public List<String> getComments() {
        return comments;
    }


    // Additional methods

    public void addComment(String comment) {
        comments.add(comment);
    }

    public Seller getCompany() {
        return company;
    }

    // Add any additional methods based on product type and category
}
