using System.Data;\nusing System.Data.SqlClient;\n\nSqlConnection connection = new SqlConnection("your_connection_string");\nSqlCommand command = new SqlCommand("GetFilteredData", connection);\ncommand.CommandType = CommandType.StoredProcedure;\n\n// Create a DataTable with the values selected in the multi-select box\nDataTable filterValuesTable = new DataTable();\nfilterValuesTable.Columns.Add("value");\n\n// Add rows to the table for each value selected in your UI\nfilterValuesTable.Rows.Add("Car");\nfilterValuesTable.Rows.Add("Truck");\n\n// Pass the DataTable as a structured parameter\nSqlParameter tvpParam = command.Parameters.AddWithValue("@FilterValues", filterValuesTable);\ntvpParam.SqlDbType = SqlDbType.Structured;\n\nconnection.Open();\nusing (var reader = command.ExecuteReader())\n{\n    // Process the data\n}