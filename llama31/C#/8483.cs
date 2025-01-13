private const string Query = @"\n    SET NOCOUNT ON;\n    SELECT col1, col2 from tableX where id = @id\n    -- more sql here\n";\n\n// ...\n\nusing (SqlConnection conn = new SqlConnection("myDbConnectionString"))\n{\n    conn.Open();\n    using (SqlCommand cmd = conn.CreateCommand())\n    {\n        cmd.CommandType = CommandType.Text;\n        cmd.CommandText = Query;\n        cmd.Parameters.AddWithValue("@id", id);\n        using (SqlDataReader rd = cmd.ExecuteReader())\n        {\n            // read data and fill object graph\n        }\n    }\n}