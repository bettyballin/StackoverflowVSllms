SET NOCOUNT ON\n\nSELECT \n    'SELECT ''' + col.TABLE_NAME + ''' AS TableName,' +\n    '''' + col.COLUMN_NAME + ''' AS ColumnName,'+\n    ' ''' +  col.DATA_TYPE + ''' as DataType,   '  +\n    '\n    (\n        SELECT top 3 CONVERT (VARCHAR, p2.' + col.COLUMN_NAME + ') + '','' \n        FROM ' + col.TABLE_SCHEMA + '.' + col.TABLE_NAME + ' p2\n        ORDER BY p2. ' +  col.COLUMN_NAME + '\n        FOR XML PATH('''') \n    )\n    UNION ALL'\nFROM INFORMATION_SCHEMA.COLUMNS col\nORDER BY \n    col.TABLE_CATALOG, \n    col.TABLE_NAME, \n    col.TABLE_SCHEMA, \n    col.ORDINAL_POSITION