using (SqlConnection connection = new SqlConnection(connectionString))\n{\n    connection.Open();\n    \n    // Create a command with parameters\n    string query = "UPDATE CM_Codebase SET [action_date] = @ActionDate WHERE [id] = @CM_id";\n    using (SqlCommand command = new SqlCommand(query, connection))\n    {\n        // ActionDate parameter setup\n        SqlParameter actionDateParam = new SqlParameter("@ActionDate", SqlDbType.DateTime);\n        if (string.IsNullOrEmpty(ActionDate))\n        {\n            actionDateParam.Value = DBNull.Value;\n        }\n        else\n        {\n            actionDateParam.Value = Convert.ToDateTime(ActionDate);\n        }\n        command.Parameters.Add(actionDateParam);\n\n        // CM_id parameter setup\n        SqlParameter cmIdParam = new SqlParameter("@CM_id", SqlDbType.Int);\n        cmIdParam.Value =YOUR_ID_VALUE; // Replace with actual ID value\n        command.Parameters.Add(cmIdParam);\n\n        // Execute the command\n        command.ExecuteNonQuery();\n    }\n}