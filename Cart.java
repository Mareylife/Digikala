import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;

    // Constructor
    public Cart() {
        this.products = new ArrayList<>();
    }

    // Getter for products
    public List<Product> getProducts() {
        return products;
    }

    // Method to add a product to the cart
    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " added to the cart.");
    }

    // Method to remove a product from the cart
    public void removeProduct(Product product) {
        products.remove(product);
        System.out.println(product.getName() + " removed from the cart.");
    }

    // Method to update the quantity of a product in the cart
    public void updateProductQuantity(Product product, int newQuantity) {
        if (newQuantity > 0) {
            System.out.println("Quantity of " + product.getName() + " updated to " + newQuantity + ".");
            product.setPurchasedQuantity(newQuantity);
           // product.setQuantity(product.getQuantity()- product.getPurchasedQuantity());
        } else {
            removeProduct(product);
        }
    }

    // Method to view the cart
    public void viewCart() {
        if (isCartempty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Cart Contents:");
            for (Product product : products) {
                System.out.println(product.getName() + " - Quantity: " + product.getPurchasedQuantity());
            }
        }
    }
    public boolean isCartempty(){
        if(products.isEmpty())
        {
            return true;
        }
        else return false;
    }
}
