-- Using INT as primary key\nCREATE TABLE Users (\n    Id INT PRIMARY KEY IDENTITY(1,1),\n    Name VARCHAR(50)\n);\n\n-- Using Unique-Identifier (GUID) as primary key\nCREATE TABLE Users (\n    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT (NEWID()),\n    Name VARCHAR(50)\n);