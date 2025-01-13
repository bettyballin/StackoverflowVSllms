DECLARE @tableName NVARCHAR(255)\nDECLARE @indexName NVARCHAR(255)\nDECLARE @sql NVARCHAR(500)\n\nDECLARE indexCursor CURSOR FOR\nSELECT \n    t.name AS tableName, \n    i.name AS indexName\nFROM \n    sysobjects t \n    JOIN sysindexes i \n    ON t.id = i.id\nWHERE \n    t.xtype = 'U' AND -- User tables\n    i.indid > 0 AND -- Non-heap indexes\n    i.indid < 255 -- Exclude hypothetical indexes\n\nOPEN indexCursor\n\nFETCH NEXT FROM indexCursor INTO @tableName, @indexName\n\nWHILE @@FETCH_STATUS = 0\nBEGIN\n    SET @sql = 'DROP INDEX [' + @tableName + '].[' + @indexName + ']'\n    EXEC sp_executesql @sql\n    FETCH NEXT FROM indexCursor INTO @tableName, @indexName\nEND\n\nCLOSE indexCursor\nDEALLOCATE indexCursor