-- Drop the table if it exists\nIF OBJECT_ID('TableName', 'U') IS NOT NULL \n    DROP TABLE TableName;\n\n-- Recreate the table\nCREATE TABLE TableName (\n    Id INT IDENTITY(1,1) PRIMARY KEY,\n    -- other columns here\n);\n\n-- Optionally, use DBCC CHECKIDENT to ensure identity starts at 1 if you're resetting after inserts\nDBCC CHECKIDENT('TableName', RESEED, 0);\nGO\n\n-- Insert a row (this should now get Id = 1)\nINSERT INTO TableName DEFAULT VALUES;