using Oracle.DataAccess.Client;\n\n// Create an Oracle connection string\nstring connectionString = "Data Source=(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=your_host)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=your_service_name)));User Id=your_username;Password=your_password;";\n\n// Create an Oracle connection object\nOracleConnection conn = new OracleConnection(connectionString);\n\n// Open the connection\nconn.Open();\n\n// Execute a query\nOracleCommand cmd = new OracleCommand("SELECT * FROM your_table", conn);\nOracleDataReader reader = cmd.ExecuteReader();\n\n// Process the results\nwhile (reader.Read())\n{\n    Console.WriteLine(reader["column_name"].ToString());\n}\n\n// Close the connection\nconn.Close();