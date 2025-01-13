SELECT \n    c.name AS ColumnName,\n    t.name AS TypeName,\n    CASE \n        WHEN t.name IN ('char', 'nchar', 'binary') THEN 'Fixed-length'\n        WHEN t.name IN ('varchar', 'nvarchar', 'varbinary') THEN 'Variable-length'\n        ELSE 'Other'\n    END AS LengthType\nFROM \n    sys.columns AS c\nINNER JOIN \n    sys.types AS t ON c.user_type_id = t.user_type_id\nWHERE \n    c.object_id = OBJECT_ID('YourTableName')\nORDER BY \n    c.column_id;