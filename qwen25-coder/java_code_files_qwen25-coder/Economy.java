import java.util.ArrayList;
import java.util.List;

public class Economy {
    private final List<Trade> trades = new ArrayList<>();
    private final List<Trader> tradersInEconomy = new ArrayList<>();

    public void addTrade(Trade trade) {
        trades.add(trade);
    }

    public int getOpenTradesCountForTrader(Trader trader) {
        return (int) trades.stream()
                           .filter(t -> t.getTrader() == trader && !t.isClosed())
                           .count();
    }

    public void updateTraders() {
        for (Trader trader : tradersInEconomy) {
            List<Trade> desiredTransactions = trader.update(this);
            for (Trade transaction : desiredTransactions) {
                addTrade(transaction);
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        Economy economy = new Economy();
        Trader trader = new Trader(economy);
        economy.tradersInEconomy.add(trader);
        economy.updateTraders();
    }
}

class Trade {
    private final Trader trader;
    private boolean closed;

    public Trade(Trader trader) {
        this.trader = trader;
        this.closed = false;
    }

    public Trader getTrader() {
        return trader;
    }

    public void closeTrade() {
        closed = true;
    }

    public boolean isClosed() {
        return closed;
    }
}

class Trader {
    private final Economy economy;

    public Trader(Economy economy) {
        this.economy = economy;
    }

    public List<Trade> update(Economy economy) {
        // Update logic here
        int openTradesCount = economy.getOpenTradesCountForTrader(this);
        System.out.println("Number of open trades: " + openTradesCount);
        return new ArrayList<>(); // Desired transactions to be added to the queue
    }
}