import java.lang.String;

class Economy {
    public void getOpenTrades() {
        // This method needs to be implemented for Trader class to work
    }
}

public class Trader {
    private Economy economy;

    public Trader(Economy economy) {
        this.economy = economy;
    }

    public void update() {
        // Access economy's methods and variables
        economy.getOpenTrades();
    }

    public static void main(String[] args) {
        Economy economy = new Economy();
        Trader trader = new Trader(economy);
        trader.update();
    }
}