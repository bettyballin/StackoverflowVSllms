using System;\nusing System.Data;\nusing System.Data.SqlClient;\n\nclass Program\n{\n    static void Main()\n    {\n        string connectionString = "your_connection_string_here";\n        SqlDataAdapter adapter = new SqlDataAdapter("SELECT * FROM your_table_name", connectionString);\n        \n        // Create and fill a DataSet (disconnected recordset)\n        DataSet dataSet = new DataSet();\n        adapter.Fill(dataSet, "YourTableName");\n\n        // Work with the data in the DataSet\n        DataTable table = dataSet.Tables["YourTableName"];\n        foreach (DataRow row in table.Rows)\n        {\n            Console.WriteLine(row["ColumnName"].ToString());\n        }\n\n        // Modify data in memory\n        DataRow newRow = table.NewRow();\n        newRow["ColumnName"] = "NewValue";\n        table.Rows.Add(newRow);\n\n        // Update the database with changes\n        SqlCommandBuilder builder = new SqlCommandBuilder(adapter);\n        adapter.Update(dataSet, "YourTableName");\n    }\n}