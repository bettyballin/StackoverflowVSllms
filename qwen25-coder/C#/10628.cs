using System;\nusing System.Collections.Generic;\nusing System.Data;\nusing System.Linq;\nusing Dapper;\n\npublic class Customer\n{\n    public int CUSTOMERNBR { get; set; }\n    public string NAME { get; set; }\n}\n\npublic class CustomerRepository\n{\n    private readonly IDbConnection _connection;\n\n    public CustomerRepository(IDbConnection connection)\n    {\n        _connection = connection;\n    }\n\n    public IEnumerable<Customer> GetAllCustomers()\n    {\n        var query = "SELECT CUSTOMERNBR, NAME FROM CUSTOMER";\n        return _connection.Query<Customer>(query);\n    }\n}