using System.Data;\nusing System.Data.SqlClient;\n\npublic class MySqlConnection : IDbConnection\n{\n    private readonly SqlConnection _sqlConnection;\n\n    public string ConnectionString\n    {\n        get => _sqlConnection.ConnectionString;\n        set\n        {\n            var builder = new SqlConnectionStringBuilder(value)\n            {\n                ApplicationName = "MyApplication"\n            };\n            _sqlConnection.ConnectionString = builder.ConnectionString;\n        }\n    }\n\n    // Other IDbConnection members\n    // ...\n\n    public MySqlConnection(SqlConnection sqlConnection)\n    {\n        _sqlConnection = sqlConnection;\n    }\n\n    // Implement other IDbConnection methods to delegate to _sqlConnection\n}