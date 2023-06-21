public class CheckoutProcess {
    private static final double SHOP_CUT_PERCENTAGE = 0.1;

    // Method to confirm an order by an admin
    public static boolean confirmOrder(Order order, Admin admin) {
        if (order.getBuyer().getWallet() >= order.getTotalPrice()) {
            double shopCut = calculateShopCut(order.getTotalPrice());
            double sellerPayment = order.getTotalPrice() - shopCut;

            // Deduct the total cost from the buyer's wallet
            double buyerWallet = order.getBuyer().getWallet();
            buyerWallet -= order.getTotalPrice();
            order.getBuyer().setWallet(buyerWallet);

            // Add a portion of the total cost to the seller's wallet
            for (int i = 0; i < order.getSeller().size(); i++ ){
                double sellerWallet = order.getSeller().get(i).getWallet();
                sellerWallet += sellerPayment;
                order.getSeller().get(i).setWallet(sellerWallet);
            }



            // Add the shop's cut to the admin's wallet
            double adminWallet = admin.getWallet();
            adminWallet += shopCut;
            admin.setWallet(adminWallet);

            // Update the stock of purchased products
            System.out.println("Order confirmed and processed successfully.");
            order.confirmOrder();
            return true;
        } else {
            System.out.println("Insufficient funds in the buyer's wallet. Order canceled.");
            return false;
        }
    }

    // Helper method to calculate the shop's cut based on the total price
    private static double calculateShopCut(double totalPrice) {
        return totalPrice * SHOP_CUT_PERCENTAGE;
    }
}
