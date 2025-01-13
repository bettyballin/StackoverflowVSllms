using (SqlConnection connection = new SqlConnection(connectionString))\n{\n    connection.Open();\n    SqlBulkCopy bulkCopy = new SqlBulkCopy(connection, SqlBulkCopyOptions.IdentityInsert);\n    bulkCopy.DestinationTableName = "orders";\n\n    // Perform your inserts here\n    bulkCopy.WriteToServer(orders);\n}