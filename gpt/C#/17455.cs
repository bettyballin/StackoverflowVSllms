using (SqlConnection conn = new SqlConnection(connectionString))\n{\n    conn.Open();\n    using (SqlCommand cmd = new SqlCommand("YourStoredProcedure", conn))\n    {\n        cmd.CommandType = CommandType.StoredProcedure;\n        using (SqlDataReader reader = cmd.ExecuteReader())\n        {\n            while (reader.Read())\n            {\n                // Process each record here\n            }\n        }\n    }\n}