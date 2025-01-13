using System.Data;\nusing System.Data.SqlClient;\n\n// Using DataTable\npublic static DataTable GetDataTable(string connectionString, string query)\n{\n    using (SqlConnection conn = new SqlConnection(connectionString))\n    {\n        SqlDataAdapter adapter = new SqlDataAdapter(query, conn);\n        DataTable dataTable = new DataTable();\n        adapter.Fill(dataTable);\n        return dataTable;\n    }\n}\n\n// Using DataSet\npublic static DataSet GetDataSet(string connectionString, string[] queries)\n{\n    using (SqlConnection conn = new SqlConnection(connectionString))\n    {\n        SqlDataAdapter adapter = new SqlDataAdapter(queries[0], conn);\n        DataSet dataSet = new DataSet();\n        \n        // Fill tables into DataSet\n        foreach(var query in queries)\n        {\n            adapter.SelectCommand.CommandText = query;\n            dataSet.Tables.Add(new DataTable());\n            adapter.Fill(dataSet.DataTables[dataSet.Tables.Count - 1]);\n        }\n        \n        return dataSet;\n    }\n}