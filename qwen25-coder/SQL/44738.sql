DECLARE @sql NVARCHAR(MAX) = N'';\n\nSELECT @sql += 'UPDATE ' + QUOTENAME(TABLE_SCHEMA) + '.' + QUOTENAME(TABLE_NAME) + '\nSET ' + QUOTENAME(COLUMN_NAME) + ' = DATEADD(year, 1, ' + QUOTENAME(COLUMN_NAME) + ')\n;'\nFROM INFORMATION_SCHEMA.COLUMNS\nWHERE DATA_TYPE = 'datetime';\n\nEXEC sp_executesql @sql;