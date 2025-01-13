using System.Data.SqlClient;\n\n// Create a connection to the database\nstring connectionString = "Your connection string";\nSqlConnection connection = new SqlConnection(connectionString);\n\n// Create a command to execute the stored procedure\nSqlCommand command = new SqlCommand("YourStoredProcedureName", connection);\ncommand.CommandType = CommandType.StoredProcedure;\n\n// Use the SqlCommandBuilder to derive the parameters\nSqlCommandBuilder.DeriveParameters(command);\n\n// Now you can access the parameters and their types\nforeach (SqlParameter parameter in command.Parameters)\n{\n    Console.WriteLine($"Parameter: {parameter.ParameterName}, Type: {parameter.SqlDbType}");\n}