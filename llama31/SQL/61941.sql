SELECT t.name AS TableName\nFROM sys.tables t\nINNER JOIN sys.columns c ON t.object_id = c.object_id\nWHERE c.name = 'YourColumnName';