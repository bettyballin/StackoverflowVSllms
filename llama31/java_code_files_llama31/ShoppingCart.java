/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<LineItem> items = new ArrayList();

    public void addItem(LineItem lineItem) {
        if (this.items.size() < 20) {
            this.items.add(lineItem);
        }
    }

    public static void main(String[] stringArray) {
    }
}
