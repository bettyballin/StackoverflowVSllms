// Open connection and begin transaction\nconnection.BeginTransaction();\n\ntry {\n    // Insert multiple rows at once using UNION ALL\n    String insertSQL = "INSERT INTO YourTable (Column1, Column2) " +\n                       "SELECT Value1_1, Value1_2 " +\n                       "UNION ALL " +\n                       "SELECT Value2_1, Value2_2 " +\n                       "UNION ALL " +\n                       "SELECT Value3_1, Value3_2";\n    command.CommandText = insertSQL;\n    command.ExecuteNonQuery();\n\n    // Retrieve the last inserted ID\n    command.CommandText = "SELECT @@IDENTITY";\n    int lastID = (int) command.ExecuteScalar();\n\n    // Use the retrieved ID for further inserts\n    String relatedInsertSQL = "INSERT INTO RelatedTable (ForeignKeyColumn, OtherColumn) VALUES (?, ?)";\n    command.CommandText = relatedInsertSQL;\n    command.Parameters.AddWithValue("?", lastID);\n    command.Parameters.AddWithValue("?", someOtherValue);\n    command.ExecuteNonQuery();\n\n    // Commit transaction\n    connection.CommitTransaction();\n} catch (Exception ex) {\n    // Handle exception and rollback transaction\n    connection.RollbackTransaction();\n    // Log or rethrow the exception\n} finally {\n    // Close the connection\n    connection.Close();\n}