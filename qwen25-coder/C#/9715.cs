using (var cmd = new SqlCeCommand("INSERT INTO YourTable (Column1, Column2) VALUES (@Value1, @Value2)", connection))\n   {\n       cmd.Parameters.AddWithValue("@Value1", value1);\n       cmd.Parameters.AddWithValue("@Value2", value2);\n       // Execute the command within a transaction after checking for existence or directly in an upsert manner\n   }