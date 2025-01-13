using System.Data;\nusing System.Data.SqlClient;\n\n// Create a connection to the database\nSqlConnection connection = new SqlConnection("Your Connection String");\n\n// Create a command to execute the stored procedure\nSqlCommand command = new SqlCommand("GetCustomerData", connection);\ncommand.CommandType = CommandType.StoredProcedure;\n\n// Create a DataSet to store the results\nDataSet dataSet = new DataSet();\n\n// Execute the stored procedure and fill the DataSet\nSqlDataAdapter adapter = new SqlDataAdapter(command);\nadapter.Fill(dataSet);\n\n// Process the results\nforeach (DataTable table in dataSet.Tables)\n{\n    // Process each table separately\n}