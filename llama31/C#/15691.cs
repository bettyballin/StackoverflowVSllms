using (var dbContext = new MyDbContext())\n{\n    var connection = dbContext.Database.Connection;\n    var schemaTable = connection.GetSchema("Tables");\n\n    // schemaTable will contain information about the tables in the database\n    // e.g., table names, column names, data types, etc.\n}