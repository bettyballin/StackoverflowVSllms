interface IRepository<T>\n{\n    IQueryable<T> GetAll();\n    T GetOne(int id);\n    void Save(T item);\n    void Delete(T item);\n}\n\nclass OrderService\n{\n    public OrderService(IReopository<Order> orderRepository, IRepository<OrderDetail> orderDetailRepository, IRepository<Payment> paymentRepository, etc) { }\n\n    public Order CreateOrder(List<OrderDetails> details)\n    {}\n    // .. other aggregate methods\n}