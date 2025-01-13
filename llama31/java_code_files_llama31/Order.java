/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

class Order {
    private List<OrderItem> orderItems;

    Order() {
    }

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(List<OrderItem> list) {
        this.orderItems = list;
    }
}
