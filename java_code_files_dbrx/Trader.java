public class Trader {
    private Economy economy; // a reference to the parent economy object

    private static final int MAX_TRADES = 10; // define MAX_TRADES

    public Trader(Economy e) {
        this.economy = e;
    }

    public Trade update() {
        int numTradesOpen = economy.getNumTrades(); // call a method on `economy`
        if (numTradesOpen >= MAX_TRADES) return null;
        else {
            // generate and return a new trade
            return new Trade();
        }
    }

    public static void main(String[] args) {
        // You can add test code here if needed
    }
}

// Define the Economy class
class Economy {
    public int getNumTrades() {
        return 0; // stub implementation
    }
}

// Define the Trade class
class Trade {
    // empty class as a placeholder
}