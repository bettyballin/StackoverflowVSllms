using System;\nusing System.Data.SqlClient;\n\npublic class SqlTableManager\n{\n    private readonly string _connectionString;\n\n    public SqlTableManager(string connectionString)\n    {\n        _connectionString = connectionString;\n    }\n\n    public void AddColumn(string tableName, string columnName, string dataType, int? length = null)\n    {\n        var commandText = $"ALTER TABLE {tableName} ADD [{columnName}] {dataType}" +\n                          (length != null ? $"({length})" : "");\n        ExecuteCommand(commandText);\n    }\n\n    public bool ColumnExists(string tableName, string columnName)\n    {\n        using (var connection = new SqlConnection(_connectionString))\n        {\n            var commandText = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = @TableName AND COLUMN_NAME = @ColumnName";\n            using (var command = new SqlCommand(commandText, connection))\n            {\n                command.Parameters.AddWithValue("@TableName", tableName);\n                command.Parameters.AddWithValue("@ColumnName", columnName);\n\n                connection.Open();\n                return (int)command.ExecuteScalar() > 0;\n            }\n        }\n    }\n\n    public void RemoveColumn(string tableName, string columnName)\n    {\n        var commandText = $"ALTER TABLE {tableName} DROP COLUMN [{columnName}]";\n        ExecuteCommand(commandText);\n    }\n\n    private void ExecuteCommand(string commandText)\n    {\n        using (var connection = new SqlConnection(_connectionString))\n        {\n            using (var command = new SqlCommand(commandText, connection))\n            {\n                connection.Open();\n                command.ExecuteNonQuery();\n            }\n        }\n    }\n}