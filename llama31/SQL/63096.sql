BEGIN TRANSACTION (DELAYED DURABILITY = ALLOWED);\n\n-- Perform insert/update/delete operations\nINSERT INTO [TableName] (...) VALUES (...);\nUPDATE [TableName] SET ... WHERE ...;\nDELETE FROM [TableName] WHERE ...;\n\n-- Commit transaction\nCOMMIT TRANSACTION;