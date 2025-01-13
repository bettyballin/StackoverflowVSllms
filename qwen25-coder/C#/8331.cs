using BusinessModels;\n\npublic interface IBusinessLogic\n{\n    User GetUser(int id);\n}\n\npublic class BusinessLogic : IBusinessLogic\n{\n    public User GetUser(int id)\n    {\n        // Logic to fetch user by ID\n        return new User { Id = id, Name = "John Doe", Email = "john.doe@example.com" };\n    }\n}