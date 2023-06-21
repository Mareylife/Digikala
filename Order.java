import java.util.Date;
import java.util.List;

public class Order {
    private User buyer;
    private List<Seller> sellers;
    private double totalPrice;
    private List<Product> purchasedProducts;


    public Order(User buyer, List<Seller> seller,List<Product> products, double totalPrice) {
        this.buyer = buyer;
        this.sellers = seller;
        this.totalPrice = totalPrice;
        this.purchasedProducts = products;
    }

    // Getter and setter methods
    public User getBuyer() {
        return buyer;
    }

    public List<Seller> getSeller() {
        return sellers;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void updateProductStock() {
        for (Product product : purchasedProducts) {
            int currentQuantity = product.getQuantity();
            int purchasedQuantity = product.getPurchasedQuantity();
            int updatedStock = currentQuantity - purchasedQuantity;
            product.setQuantity(updatedStock);
        }
    }
    public void confirmOrder() {
        // Update the product stock
        updateProductStock();
        buyer.addOrder(this);
        for (Seller seller: sellers) {
            seller.addOrder(this);
        }


        // Mark the order as confirmed
        // Additional logic as per your requirements
    }


}
