-- Create a new Utility Database\nCREATE DATABASE UtilityDB;\nGO\n\nUSE UtilityDB;\nGO\n\n-- Example Stored Procedure in the Utility Database\nCREATE PROCEDURE sp_CleanUpTempTables\nAS\nBEGIN\n    EXEC sp_MSforeachtable @command1 = "DROP TABLE IF EXISTS ? WHERE SCHEMA_NAME(schema_id) = 'dbo' AND is_ms_shipped <> 1";\nEND;\nGO