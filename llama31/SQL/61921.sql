DECLARE @sql NVARCHAR(MAX) = N'';\n\nSELECT @sql += N'ALTER TABLE table_name ALTER COLUMN ' + QUOTENAME(c.name) + N' COLLATE new_collation_name; '\nFROM sys.columns c\nWHERE c.object_id = OBJECT_ID('table_name');\n\nEXEC sp_executesql @sql;