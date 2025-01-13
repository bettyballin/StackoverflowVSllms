using System;\nusing Oracle.ManagedDataAccess.Client;\n\nclass Program\n{\n    static void Main()\n    {\n        string connectionString = "your_connection_string_here";\n        using (var connection = new OracleConnection(connectionString))\n        {\n            connection.Open();\n            OracleTransaction transaction = connection.BeginTransaction();\n\n            try\n            {\n                var sqlCommands = new[]\n                {\n                    "insert into your_table (column1) values ('value1')",\n                    "insert into another_table (column2) values ('value2')",\n                    "delete from some_table where condition"\n                };\n\n                foreach (var commandText in sqlCommands)\n                {\n                    using (var command = new OracleCommand(commandText, connection))\n                    {\n                        command.Transaction = transaction;\n                        command.ExecuteNonQuery();\n                    }\n                }\n\n                transaction.Commit(); // Commit the transaction\n            }\n            catch (Exception ex)\n            {\n                Console.WriteLine("An error occurred: " + ex.Message);\n                transaction.Rollback(); // Rollback in case of an error\n            }\n        }\n    }\n}