string connectionString = "your_connection_string_here";\nusing (SqlConnection dbConn = new SqlConnection(connectionString))\n{\n    dbConn.Open();\n    using (var cmd = new SqlCommand("GetData", dbConn))\n    {\n        cmd.CommandType = CommandType.StoredProcedure;\n        cmd.Parameters.AddWithValue("@id", id);\n\n        SomeDataObject dataObject = null;\n\n        using (var dr = cmd.ExecuteReader(CommandBehavior.SingleRow))\n        {\n            if (dr.Read())\n                dataObject = new SomeDataObject(dr);\n        }\n\n        return dataObject;\n    }\n}