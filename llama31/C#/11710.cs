using (SqlCommand cmd = new SqlCommand("SELECT * FROM MyTable WHERE DateField = @Date", connection))\n{\n    cmd.Parameters.AddWithValue("@Date", DateTime.Now);\n    // Execute the command\n}