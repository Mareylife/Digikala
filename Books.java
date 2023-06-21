import java.util.ArrayList;
import java.util.List;

public class Books extends Product {
    private String name;
    private double price;
    //private int stock;
    private int quantity;

    private int purchasedQuantity;
    private Seller company;

    public Books(String name, double price, int quantity,Seller company) {
        super(name,price,quantity,company);

    }
    public ArrayList <Product> products = new ArrayList<Product>();
    // Constructor
}