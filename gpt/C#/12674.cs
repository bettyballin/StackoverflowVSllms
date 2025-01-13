using Oracle.DataAccess.Client;\n\n    string connectionString = "User Id=myUsername;Password=myPassword;Data Source=myDataSource";\n    using (OracleConnection connection = new OracleConnection(connectionString))\n    {\n        connection.Open();\n        string query = "YOUR SQL QUERY HERE";\n        using (OracleCommand command = new OracleCommand(query, connection))\n        {\n            using (OracleDataReader reader = command.ExecuteReader())\n            {\n                while (reader.Read())\n                {\n                    // Process data\n                }\n            }\n        }\n    }