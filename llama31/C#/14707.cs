using Dapper;\n\n// assume you have a SqlConnection instance named 'connection'\nvar customers = connection.Query<Customer>("SELECT * FROM Customers");\n\npublic class Customer\n{\n    public int Id { get; set; }\n    public string Name { get; set; }\n}