SELECT \n    STUFF((\n        SELECT ',' + ColumnName\n        FROM YourTableName\n        FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 1, '') AS CommaDelimitedOutput;