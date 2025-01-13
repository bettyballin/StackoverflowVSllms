DECLARE @ColumnName NVARCHAR(128) = 'YourColumnName';\nDECLARE @TableName NVARCHAR(128) = 'YourTableName';\n\nSELECT \n    p.name AS ProcedureName,\n    OBJECT_DEFINITION(p.object_id) AS ProcedureDefinition\nFROM \n    sys.procedures AS p\nJOIN \n    sys.sql_modules AS m\n    ON p.object_id = m.object_id\nWHERE \n    m.definition LIKE '%' + @ColumnName + '%'\n    AND m.definition LIKE '%' + @TableName + '%'\n    AND m.definition LIKE '%UPDATE%'\nORDER BY \n    p.name;