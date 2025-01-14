DECLARE @validTables TABLE (TableName NVARCHAR(128));\nINSERT INTO @validTables (TableName) VALUES ('Table1'), ('Table2'), ('Table3'); -- Add valid table names\n\nIF NOT EXISTS (SELECT 1 FROM @validTables WHERE TableName = @table)\nBEGIN\n    RAISERROR('Invalid table name provided.', 16, 1);\n    RETURN;\nEND