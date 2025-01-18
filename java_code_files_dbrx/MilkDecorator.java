public abstract class Beverage {
    public abstract String getDescription();
    public abstract double cost();
}

public class Espresso extends Beverage {
    public String getDescription() {
        return "Espresso";
    }

    public double cost() {
        return 1.99;
    }
}

public abstract class CondimentDecorator extends Beverage {
    protected Beverage beverage;
}

public class Milk extends CondimentDecorator {
    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    public double cost() {
        return beverage.cost() + 0.20;
    }
}

public class MilkDecorator {
    public static void main(String[] args) {
        Beverage drink = new Espresso();
        drink = new Milk(drink); // add milk decoration
        System.out.println(drink.getDescription() + " $" + drink.cost());
    }
}