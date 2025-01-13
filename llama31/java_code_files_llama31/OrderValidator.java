/*
 * Decompiled with CFR 0.152.
 */
public class OrderValidator {
    public void validate(Order order) throws InvalidOrderException {
        if (order.getCustomer() == null || order.getCustomer().getId() == null) {
            throw new InvalidOrderException("Invalid customer");
        }
        if (order.getOrderItems().isEmpty()) {
            throw new InvalidOrderException("No order items");
        }
        PostalAddress postalAddress = order.getShippingAddress();
        if (postalAddress == null || !postalAddress.isValid()) {
            throw new InvalidOrderException("Invalid shipping address");
        }
    }

    public static void main(String[] stringArray) {
        OrderValidator orderValidator = new OrderValidator();
        try {
            Order order = new Order();
            orderValidator.validate(order);
        }
        catch (InvalidOrderException invalidOrderException) {
            System.out.println(invalidOrderException.getMessage());
        }
    }
}
