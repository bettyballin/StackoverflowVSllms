using (SqlConnection conn = new SqlConnection(connection))\n{\n    SqlDataAdapter adapter = new SqlDataAdapter();\n    adapter.SelectCommand = new SqlCommand(query, conn);\n    adapter.Fill(dataset);\n    return dataset;\n}