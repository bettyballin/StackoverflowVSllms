using NServiceBus;\n\n// Define a message\npublic class PlaceOrder : ICommand\n{\n    public int OrderId { get; set; }\n}\n\n// Send a message\npublic class OrderController\n{\n    private readonly IBus _bus;\n\n    public OrderController(IBus bus)\n    {\n        _bus = bus;\n    }\n\n    public void PlaceOrder(int orderId)\n    {\n        var command = new PlaceOrder { OrderId = orderId };\n        _bus.Send(command);\n    }\n}\n\n// Handle a message\npublic class OrderProcessor : IHandleMessages<PlaceOrder>\n{\n    public void Handle(PlaceOrder message)\n    {\n        // Process the order\n        Console.WriteLine($"Processing order {message.OrderId}");\n    }\n}