DECLARE @sql NVARCHAR(MAX) = N'';\n\nSELECT @sql += N'\nUNION ALL\nSELECT ''' + QUOTENAME(TABLE_SCHEMA) + '.' + QUOTENAME(TABLE_NAME) + ''' AS TableName, \n       COUNT(*) AS RowCounts\nFROM ' + QUOTENAME(TABLE_SCHEMA) + '.' + QUOTENAME(TABLE_NAME)\nFROM INFORMATION_SCHEMA.TABLES\nWHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA = 'dbo';\n\n-- Remove the leading UNION ALL\nSET @sql = STUFF(@sql, 1, 10, '');\n\n-- Execute the dynamic SQL\nEXEC sp_executesql @sql;