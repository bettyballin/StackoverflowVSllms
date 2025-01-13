// Using a DataReader\nusing (SqlConnection connection = new SqlConnection(connectionString))\n{\n    connection.Open();\n    SqlCommand command = new SqlCommand("SELECT * FROM MyTable", connection);\n    SqlDataReader reader = command.ExecuteReader();\n\n    while (reader.Read())\n    {\n        // Process one row at a time\n        Console.WriteLine(reader["MyColumn"]);\n    }\n}\n\n// Using a DataSet\nusing (SqlConnection connection = new SqlConnection(connectionString))\n{\n    connection.Open();\n    SqlDataAdapter adapter = new SqlDataAdapter("SELECT * FROM MyTable", connection);\n    DataSet dataSet = new DataSet();\n    adapter.Fill(dataSet);\n\n    foreach (DataRow row in dataSet.Tables[0].Rows)\n    {\n        // Process one row at a time, but with higher overhead\n        Console.WriteLine(row["MyColumn"]);\n    }\n}