using NUnit.Framework;\nusing System.Data;\nusing System.Data.SqlClient;\n\npublic class DatabaseTestBase\n{\n    private IDbConnection _connection;\n    private IDbTransaction _transaction;\n\n    [SetUp]\n    public void SetUp()\n    {\n        _connection = new SqlConnection("your-connection-string");\n        _connection.Open();\n        _transaction = _connection.BeginTransaction();\n    }\n\n    [TearDown]\n    public void TearDown()\n    {\n        _transaction.Rollback();\n        _connection.Close();\n    }\n\n    protected IDbConnection Connection => _connection;\n    protected IDbTransaction Transaction => _transaction;\n}\n\n// Example usage in a test class\npublic class MyIntegrationTests : DatabaseTestBase\n{\n    [Test]\n    public void TestDatabaseOperation()\n    {\n        // Perform database operations using Connection and Transaction\n        var command = Connection.CreateCommand();\n        command.Transaction = Transaction;\n        command.CommandText = "INSERT INTO TestTable (Column1) VALUES ('TestValue')";\n        command.ExecuteNonQuery();\n\n        // Assert results\n        var verifyCommand = Connection.CreateCommand();\n        verifyCommand.Transaction = Transaction;\n        verifyCommand.CommandText = "SELECT COUNT(*) FROM TestTable WHERE Column1 = 'TestValue'";\n        var result = (int)verifyCommand.ExecuteScalar();\n        Assert.AreEqual(1, result);\n    }\n}