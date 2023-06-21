import java.util.ArrayList;

public class Electronics extends Product {
    private String name;
    private double price;
    //private int stock;
    private int quantity;

    private int purchasedQuantity;
    private Seller company;

    public Electronics(String name, double price, int quantity,Seller company) {
        super(name,price,quantity,company);
    }
}