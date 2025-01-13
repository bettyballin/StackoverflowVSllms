import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<LineItem> items = new ArrayList<>();

    public void addItem(LineItem item) {
        if (items.size() < 20) {
            items.add(item);
        }
    }

    public static void main(String[] args) {
    }
}

class LineItem {
    // This is a placeholder for the LineItem class. 
    // You should implement the actual LineItem class according to your requirements.
}