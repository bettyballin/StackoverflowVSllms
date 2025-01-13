public interface IUserContext\n{\n    User LoggedInUser { get; set; }\n}\n\npublic class UserContext : IUserContext\n{\n    public User LoggedInUser { get; set; }\n}\n\npublic class OrdersService\n{\n    private readonly IUserContext _userContext;\n\n    public OrdersService(IUserContext userContext)\n    {\n        _userContext = userContext;\n    }\n\n    public IEnumerable<Order> GetOrdersByUserID()\n    {\n        if (_userContext.LoggedInUser == null)\n            throw new InvalidOperationException("User not logged in.");\n\n        return GetDataForUser(_userContext.LoggedInUser.ID);\n    }\n\n    private IEnumerable<Order> GetDataForUser(int userId)\n    {\n        // Mock method to simulate data retrieval\n        return Enumerable.Empty<Order>();\n    }\n}\n\npublic class OrderListPresenter\n{\n    private readonly OrdersService _ordersService;\n\n    public OrderListPresenter(IUserContext userContext)\n    {\n        // Here we inject the same UserContext instance that is set when the user logs in.\n        _ordersService = new OrdersService(userContext);\n    }\n\n    public IEnumerable<Order> GetOrders()\n    {\n        try\n        {\n            return _ordersService.GetOrdersByUserID();\n        }\n        catch (InvalidOperationException ex)\n        {\n            // Handle exception, e.g., show a message to the user\n            Console.WriteLine(ex.Message);\n            return Enumerable.Empty<Order>();\n        }\n    }\n}