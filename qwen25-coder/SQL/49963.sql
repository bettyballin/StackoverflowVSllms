SELECT \n    t.name AS TableName,\n    c.name AS ColumnName,\n    c.collation_name AS CollationName\nFROM \n    sys.tables AS t\nINNER JOIN \n    sys.columns AS c ON t.object_id = c.object_id\nWHERE \n    t.name = N'tmpTable' AND c.name = N'fldField';