/*
 * Decompiled with CFR 0.152.
 */
public class EconomyMediator {
    private Economy economy;
    private Trader trader;

    public EconomyMediator(Economy economy, Trader trader) {
        this.economy = economy;
        this.trader = trader;
    }

    public void updateTrader() {
        this.trader.update(this.economy.getOpenTrades());
    }

    public static void main(String[] stringArray) {
        Economy economy = new Economy();
        Trader trader = new Trader();
        EconomyMediator economyMediator = new EconomyMediator(economy, trader);
        economyMediator.updateTrader();
    }
}
