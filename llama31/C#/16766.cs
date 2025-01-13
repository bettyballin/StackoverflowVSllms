public class Foo\n{\n    private const String myTableName = "mytable";\n    private static readonly HashSet<string> allowedTableNames = new HashSet<string> { "mytable", "othertable" };\n\n    public void Bar()\n    {\n        if (!allowedTableNames.Contains(myTableName))\n        {\n            throw new InvalidOperationException($"Invalid table name: {myTableName}");\n        }\n\n        string query = $"SELECT * FROM {myTableName}";\n        NpgsqlCommand command = new NpgsqlCommand(query, connection);\n        // ...\n    }\n}