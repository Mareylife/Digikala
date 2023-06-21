import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop("MyDigiKala","www.mydigikala.apProject.ir","021***56");

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do{
            System.out.println("==== MENU ====");
            System.out.println("1. Add Account");
            System.out.println("2. Add Product");
            System.out.println("3. Add Order");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            boolean isThatUser = true;
            switch (choice) {
                case 1:
                    isThatUser = addAccount(scanner,shop);
                    do{
                        if(isThatUser == true) {
                            shop.currentUser = (User) shop.getUserAccounts().get(0);
                            System.out.println("1. view Product Catalog");
                            System.out.println("2. search product and add to your cart");
                            //System.out.println("3. add order");
                            System.out.println("3. view cart");
                            System.out.println("4. back to main menu");
                            choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    shop.getProducts();
                                    break;
                                case 2:
                                    System.out.println("in which category you want to search:" +
                                            "1. Books" +
                                            "2. Clothes" +
                                            "3. Electronics");
                                    choice = scanner.nextInt();
                                    switch (choice) {
                                        case 1:
                                            System.out.println("please enter the name of the product you are looking for: ");
                                            String name = scanner.next();
                                            shop.searchBookProducts(name);
                                            System.out.println("choose an index to order");
                                            choice = scanner.nextInt();
                                            addToCart(shop.searchBookProducts(name).get(choice), shop);
                                            break;
                                        case 2:
                                            System.out.println("please enter the name of the product you are looking for: ");
                                            name = scanner.next();
                                            shop.searchClotheProducts(name);
                                            System.out.println("choose an index to order");
                                            choice = scanner.nextInt();
                                            addToCart(shop.searchClotheProducts(name).get(choice), shop);
                                            break;
                                        case 3:
                                            System.out.println("please enter the name of the product you are looking for: ");
                                            name = scanner.next();
                                            shop.searchElecProducts(name);
                                            System.out.println("choose an index to order. enter 0 for canceling");
                                            choice = scanner.nextInt();
                                            if(choice == 0)
                                            {
                                                break;
                                            }
                                            else {
                                                addToCart(shop.searchElecProducts(name).get(choice-1), shop);
                                                break;
                                            }
                                    }
                                    break;
                                case 3:
                                    shop.cart.viewCart();
                                    if(shop.cart.isCartempty())
                                    {
                                        break;
                                    }
                                    else {
                                        System.out.println("choose the index of which product you wanna change?");
                                        int index = scanner.nextInt();
                                        System.out.println("do you wanna change it?"
                                                + "1. Update Product Quantity"
                                                + "2. remove product");
                                        choice = scanner.nextInt();
                                        Product currentProduct = shop.products.get(index);
                                        switch (choice) {
                                            case 1:
                                                System.out.println("enter the quantity :");
                                                int quantity = scanner.nextInt();
                                                shop.cart.updateProductQuantity(currentProduct, quantity);
                                                //currentProduct.setQuantity(currentProduct.getQuantity() - quantity);
                                                break;
                                            case 2:
                                                shop.cart.removeProduct(currentProduct);
                                                break;
                                        }
                                    }
                                    break;

                            }
                        }
                        else {
                            shop.currentAdmin = shop.getAdminAccounts().get(0);
                            shop.mainAdmin = (Admin) shop.currentAdmin;
                            System.out.println("returning to main menu...");
                            break;
                        }
                    }while (choice != 4);
                    break;
                case 2:
                    addProduct(shop, scanner);
                    break;
                case 3:
                    shop.currentUser = (User) shop.getUserAccounts().get(0);
                    addOrder(shop.currentUser,shop.cart.getProducts(),shop);
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    break;
            }
        }while (choice!= 5);


    }

    private static boolean addAccount(Scanner scanner, Shop shop) {
        boolean isThatUser = true;
        System.out.println("choose the type of account :"
                + " 1. User"
                + " 2. Admin");
        int choose = scanner.nextInt();
        if(choose == 1){
            System.out.print("Enter username: ");
            String username = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();
            System.out.print("Enter email: ");
            String email = scanner.next();
            System.out.print("Enter phone number: ");
            String phoneNumber = scanner.next();
            System.out.print("Enter address: ");
            String address = scanner.next();
            System.out.print("Enter wallet balance: ");
            double wallet = scanner.nextDouble();

            User user = new User(username, password, email, phoneNumber, address, wallet);
            shop.setAccounts(user);
            System.out.println("User added successfully!");
        }
        else {
            System.out.print("Enter username: ");
            String username = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();
            System.out.print("Enter email: ");
            String email = scanner.next();
            System.out.print("Enter wallet balance: ");
            double wallet = scanner.nextDouble();
            Admin admin = new Admin(username,password,email,wallet);
            shop.setAccounts(admin);
            System.out.println("Admin added successfully!");
            isThatUser = false;
        }
        return isThatUser;
    }

    private static void addProduct(Shop shop, Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.next();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Category: 1.Book 2.Clothe " + "3.Electronics");
        int category = scanner.nextInt();
        System.out.println("Enter the company name(seller) : ");
        String companyName= scanner.next();
        Seller seller = new Seller(companyName,"01234");
        Product product = new Product(name, price, quantity, seller);
        shop.setProducts(product);
        if(category == 1)
        {
            shop.books.add(product);
        }
        else if(category == 2){
            shop.clothes.add(product);
        }
        else {
            shop.electronics.add(product);
        }

        System.out.println("Product added successfully!");
    }
    private static void addOrder(User user, List<Product> products, Shop shop) {
        List<Seller> sellers = new ArrayList<>();
        double totalPrice = 0;
        for (int i = 0 ; i < products.size(); i++)
        {
            sellers.add(products.get(i).getCompany());
            totalPrice += products.get(i).getPrice();
        }
        Order order = new Order(user,sellers,products,totalPrice);
        shop.setOrders(order);
        if (CheckoutProcess.confirmOrder(order,shop.mainAdmin)) {
            System.out.println("Order confirmed successfully!");
        } else {
            System.out.println("Insufficient funds. Order canceled.");
        }
    }
    private static void addToCart(Product product,Shop shop)
    {
        shop.cart.addProduct(product);
    }

}