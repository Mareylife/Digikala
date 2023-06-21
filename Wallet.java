public class Wallet {
    private double balance;

    // Constructor
    public Wallet() {
        this.balance = 0.0;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Method to add funds to the wallet
    public void addFunds(double amount) {
        balance += amount;
    }

    // Method to subtract funds from the wallet
    public void subtractFunds(double amount) {
        balance -= amount;
    }
}
