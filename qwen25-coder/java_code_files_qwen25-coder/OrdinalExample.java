import java.util.*;

class OrderedItem {
    private int ordinal;
    private String name;

    public OrderedItem(int ordinal, String name) {
        this.ordinal = ordinal;
        this.name = name;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public int getOrdinal() {
        return ordinal;
    }

    @Override
    public String toString() {
        return "OrderedItem{" +
                "ordinal=" + ordinal +
                ", name='" + name + '\'' +
                '}';
    }
}

public class OrdinalExample {
    public static void main(String[] args) {
        List<OrderedItem> items = new ArrayList<>();
        items.add(new OrderedItem(1000, "First"));
        items.add(new OrderedItem(2000, "Second"));
        items.add(new OrderedItem(3000, "Third"));

        System.out.println("Original List: ");
        for (OrderedItem item : items) {
            System.out.println(item);
        }

        // Reorder: Move Second after Third
        OrderedItem secondItem = items.get(1);
        secondItem.setOrdinal(3500);

        Collections.sort(items, Comparator.comparingInt(OrderedItem::getOrdinal));

        System.out.println("\nReordered List: ");
        for (OrderedItem item : items) {
            System.out.println(item);
        }
    }
}