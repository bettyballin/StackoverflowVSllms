public class MyRepository\n{\n    private readonly IDbConnection _connection;\n\n    public MyRepository(IDbConnection connection)\n    {\n        _connection = connection;\n    }\n\n    public void AddSomething(string something)\n    {\n        using (_connection)\n        {\n            _connection.Open();\n            // ...\n        }\n    }\n}