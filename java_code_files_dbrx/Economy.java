import java.util.ArrayList;
import java.util.List;

public class Economy {
    private List<Trade> trades; // the list of all trades in the economy
    private List<Trader> traders; // the list of traders in the economy
    private static final int NUM_TRADERS = 10;

    public Economy() {
        this.trades = new ArrayList<>();
        this.traders = new ArrayList<>();
        for (int i = 0; i < NUM_TRADERS; i++) {
            Trader trader = new Trader(this); // pass `this` to the trader on creation
            traders.add(trader);
        }
    }

    public void update() {
        for (Trader trader : traders) {
            Trade trade = trader.update();
            if (trade != null) trades.add(trade);
        }
    }

    public static void main(String[] args) {
    }
}

class Trader {
    private Economy economy;

    public Trader(Economy economy) {
        this.economy = economy;
    }

    public Trade update() {
        return null;
    }
}

class Trade {
}