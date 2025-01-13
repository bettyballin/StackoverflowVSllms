using System;\nusing Oracle.ManagedDataAccess.Client;\n\nclass Program\n{\n    static void Main()\n    {\n        string connectionString = "your_connection_string_here";\n        using (OracleConnection connection = new OracleConnection(connectionString))\n        {\n            connection.Open();\n            \n            // Use this command to select a Timestamp from your table\n            using (OracleCommand command = new OracleCommand("SELECT timestamp_column FROM your_table WHERE id = 1", connection))\n            {\n                object result = command.ExecuteScalar();\n\n                if (result != null)\n                {\n                    DateTime dateWithMilliseconds = Convert.ToDateTime(result);\n                    Console.WriteLine("Timestamp from Oracle: " + dateWithMilliseconds.ToString("yyyy-MM-dd HH:mm:ss.fff"));\n                }\n            }\n        }\n    }\n}