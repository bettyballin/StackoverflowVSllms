using (DbCommand command = connection.CreateCommand())\n{\n    command.CommandText = "YourStoredProcedureOrQuery";\n    // Set other command properties and execute the command\n}