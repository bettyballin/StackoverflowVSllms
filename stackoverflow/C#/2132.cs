using (SqlConnection connection = openConnection())\n{\n    command.Connection = connection;\n    ExecuteReaderWithCommand(command, reader =>\n    {\n        // Do stuff with the result here.\n    });\n}