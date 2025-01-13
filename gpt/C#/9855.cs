using Microsoft.Extensions.Configuration;\nusing Xunit;\n\npublic class BusinessLogicTests\n{\n    private readonly IConfiguration _configuration;\n\n    public BusinessLogicTests()\n    {\n        var builder = new ConfigurationBuilder()\n            .SetBasePath(Directory.GetCurrentDirectory())\n            .AddJsonFile("appsettings.json");\n\n        _configuration = builder.Build();\n    }\n\n    [Fact]\n    public void TestMethod()\n    {\n        var testConnectionString = _configuration.GetConnectionString("TestDatabase");\n        var dbConnection = new DatabaseConnection(testConnectionString);\n\n        // Execute tests using the test database connection\n    }\n}