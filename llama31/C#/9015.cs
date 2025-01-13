using (SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings["mydbconn"].ConnectionString))\n{\n    conn.Open();\n    Server sv = new Server(new Microsoft.SqlServer.Management.Common.ServerConnection(conn));\n    Database db = sv.Databases["mydb"];\n\n    foreach (StoredProcedure sp in db.StoredProcedures)\n    {\n        string query = $"EXEC sp_describe_first_result_set_for_object @object_id = {sp.ID}";\n        DataTable result = new DataTable();\n        using (SqlCommand cmd = new SqlCommand(query, conn))\n        {\n            result.Load(cmd.ExecuteReader());\n        }\n\n        foreach (DataRow row in result.Rows)\n        {\n            string columnName = row["name"].ToString();\n            string dataType = row["system_type_name"].ToString();\n            // Process the column metadata here\n        }\n    }\n}