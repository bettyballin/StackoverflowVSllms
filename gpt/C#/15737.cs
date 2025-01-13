using System;\nusing System.Data;\nusing System.Data.Odbc;\n\npublic bool TableExists(OdbcConnection connection, string tableName)\n{\n    const string sqlStatement = @"\n        SELECT COUNT(*)\n        FROM INFORMATION_SCHEMA.TABLES\n        WHERE TABLE_NAME = ?";\n\n    using (OdbcCommand cmd = new OdbcCommand(sqlStatement, connection))\n    {\n        cmd.Parameters.Add(new OdbcParameter("TABLE_NAME", tableName));\n\n        try\n        {\n            return (int)cmd.ExecuteScalar() > 0;\n        }\n        catch (Exception ex)\n        {\n            // Handle exception (log it, rethrow it, etc.)\n            return false;\n        }\n    }\n}