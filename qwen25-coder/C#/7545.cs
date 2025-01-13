// Start Transaction\ncommand.CommandText = "BEGIN IMMEDIATE TRANSACTION;";\ncommand.ExecuteNonQuery();\n\ntry {\n    // Update Statement\n    command.CommandText = "UPDATE tag_name SET count = count+1 WHERE tagid=@tagid;";\n    command.Parameters.Add("@tagid", DbType.Int64).Value = tagId;\n    command.ExecuteNonQuery();\n\n    // Commit Transaction\n    command.CommandText = "COMMIT;";\n    command.ExecuteNonQuery();\n} catch (Exception) {\n    // Rollback in case of error\n    command.CommandText = "ROLLBACK;";\n    command.ExecuteNonQuery();\n    throw; // Re-throw the exception after rollback\n}