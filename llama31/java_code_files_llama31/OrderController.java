/*
 * Decompiled with CFR 0.152.
 */
class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void placeOrder(OrderModel orderModel) {
        Order order = new Order(orderModel.getOrderId(), orderModel.getCustomerName());
        this.orderService.placeOrder(order);
    }

    public static void main(String[] stringArray) {
        OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
        OrderController orderController = new OrderController(orderServiceImpl);
        OrderModel orderModel = new OrderModel();
        orderModel.setOrderId("123");
        orderModel.setCustomerName("John Doe");
        orderController.placeOrder(orderModel);
    }
}
