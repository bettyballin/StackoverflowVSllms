public class MyDataContext : DataContext\n{\n    public Table<Customer> Customers;\n    public Table<Order> Orders;\n    // Other tables...\n\n    public MyDataContext(string connectionString) : base(connectionString) { }\n}