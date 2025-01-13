// Assuming you have a DataTable that matches the type of your TVP\nDataTable dt = new DataTable();\ndt.Columns.Add("ID", typeof(int));\nforeach (int id in recordIdList)\n{\n    dt.Rows.Add(id);\n}\n\nusing (SqlConnection con = new SqlConnection(connectionString))\n{\n    using (SqlCommand cmd = new SqlCommand("SELECT * FROM Table WHERE RecordID IN (SELECT ID FROM @IdsTable)", con))\n    {\n        SqlParameter tvpParam = cmd.Parameters.AddWithValue("@IdsTable", dt);\n        tvpParam.SqlDbType = SqlDbType.Structured;\n        tvpParam.TypeName = "dbo.RecordIDTableType"; // Name of your TVP type\n\n        using (SqlDataReader reader = cmd.ExecuteReader())\n        {\n            while (reader.Read())\n            {\n                // Process each row here\n            }\n        }\n    }\n}