public class SimpleDrink {
    // Example: Adding condiments to drinks
    interface Drink {}
    class SimpleDrinkImpl implements Drink {}
    abstract class CondimentDecorator implements Drink {
        protected Drink decoratedDrink;
    }

    public static void main(String[] args) {
    }
}