DECLARE @InjectedText NVARCHAR(MAX) = N'<script src="malicious.js"></script>'; -- Replace with the actual injected text\nDECLARE @sql NVARCHAR(MAX) = N'';\nDECLARE @table NVARCHAR(MAX);\nDECLARE @column NVARCHAR(MAX);\n\n-- Cursor to iterate over all text-like columns in the database\nDECLARE cur CURSOR FOR\nSELECT \n    QUOTENAME(TABLE_SCHEMA) + '.' + QUOTENAME(TABLE_NAME) AS TableName,\n    QUOTENAME(COLUMN_NAME) AS ColumnName\nFROM \n    INFORMATION_SCHEMA.COLUMNS\nWHERE \n    DATA_TYPE IN ('varchar', 'nvarchar', 'text', 'ntext') -- Add other data types if necessary\n\nOPEN cur;\nFETCH NEXT FROM cur INTO @table, @column;\n\nWHILE @@FETCH_STATUS = 0\nBEGIN\n    SET @sql = @sql + '\n    UPDATE ' + @table + '\n    SET ' + @column + ' = LEFT(' + @column + ', LEN(' + @column + ') - LEN(@InjectedText))\n    WHERE ' + @column + ' LIKE ''%' + @InjectedText + ''';';\n\n    FETCH NEXT FROM cur INTO @table, @column;\nEND\n\nCLOSE cur;\nDEALLOCATE cur;\n\n-- Execute the generated SQL script\nEXEC sp_executesql @sql, N'@InjectedText NVARCHAR(MAX)', @InjectedText;