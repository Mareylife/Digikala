import java.util.ArrayList;

public class Clothes extends Product {
    // Constructor
    private String name;
    private double price;
    //private int stock;
    private int quantity;

    private int purchasedQuantity;
    private Seller company;

    public Clothes(String name, double price, int quantity,Seller company) {
        super(name,price,quantity,company);
        this.name = name;
        this.price = price;
        this.company = company;
        this.quantity = quantity;
    }

}