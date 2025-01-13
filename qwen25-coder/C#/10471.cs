public async Task ResetDatabaseAsync()\n{\n    await dbContext.Database.EnsureDeletedAsync();\n    await dbContext.Database.MigrateAsync();\n    // Seed data as needed\n}