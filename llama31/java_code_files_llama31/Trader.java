/*
 * Decompiled with CFR 0.152.
 */
public class Trader {
    private Economy economy;

    public Trader(Economy economy) {
        this.economy = economy;
    }

    public void update() {
        this.economy.getOpenTrades();
    }

    public static void main(String[] stringArray) {
        Economy economy = new Economy();
        Trader trader = new Trader(economy);
        trader.update();
    }
}
