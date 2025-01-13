// Define the EconomyCallback interface
public interface EconomyCallback {
    int getOpenTrades();
}

// Define the Economy class that implements EconomyCallback
public class Economy implements EconomyCallback {
    // Implement the getOpenTrades() method
    public int getOpenTrades() {
        // For demonstration purposes, return a fixed value
        return 10;
    }
}

// Define the Trader class
public class Trader {
    private EconomyCallback economyCallback;

    // Constructor to initialize economyCallback
    public Trader(EconomyCallback economyCallback) {
        this.economyCallback = economyCallback;
    }

    // Method to update and call the callback method
    public void update() {
        // Call the callback method
        int openTrades = economyCallback.getOpenTrades();
        System.out.println("Number of open trades: " + openTrades);
    }

    // Main method to test the code
    public static void main(String[] args) {
        // Create an instance of Economy
        Economy economy = new Economy();
        
        // Create an instance of Trader with the Economy instance
        Trader trader = new Trader(economy);
        
        // Call the update method to test the callback
        trader.update();
    }
}