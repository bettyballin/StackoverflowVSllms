SELECT s.name AS SchemaName, o.name AS ObjectName, p.name AS Owner\n    FROM sys.objects o\n    JOIN sys.schemas s ON o.schema_id = s.schema_id\n    JOIN sys.database_principals p ON o.principal_id = p.principal_id\n    WHERE o.name IN ('MyView', 'UnderlyingTable');