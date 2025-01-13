DECLARE @SQL NVARCHAR(MAX)\nDECLARE @TableName NVARCHAR(MAX)\n\nDECLARE TableCursor CURSOR FOR\nSELECT TABLE_SCHEMA + '.' + TABLE_NAME\nFROM INFORMATION_SCHEMA.TABLES\nWHERE TABLE_TYPE = 'BASE TABLE'\n\nOPEN TableCursor\n\nFETCH NEXT FROM TableCursor INTO @TableName\n\nWHILE @@FETCH_STATUS = 0\nBEGIN\n    SET @SQL = 'SELECT ''INSERT INTO ' + @TableName + ' ('\n\n    SELECT @SQL = @SQL + SUBSTRING((SELECT ', [' + COLUMN_NAME + ']'\n                                    FROM INFORMATION_SCHEMA.COLUMNS\n                                    WHERE TABLE_NAME = PARSENAME(@TableName, 1)\n                                    FOR XML PATH('')), 2, 1000000) + ') VALUES ('' +'\n\n    SELECT @SQL = @SQL + SUBSTRING((SELECT ' + ISNULL('''''''' + REPLACE(CAST([' + COLUMN_NAME + '] AS NVARCHAR(MAX)), '''''''', '''''''''') + '''''''', ''''NULL'''') + ' + '', '' +'\n                                    FROM INFORMATION_SCHEMA.COLUMNS\n                                    WHERE TABLE_NAME = PARSENAME(@TableName, 1)\n                                    FOR XML PATH('')), 1, 10000000) + ''');'' FROM ' + @TableName\n\n    EXEC sp_executesql @SQL\n\n    FETCH NEXT FROM TableCursor INTO @TableName\nEND\n\nCLOSE TableCursor\nDEALLOCATE TableCursor