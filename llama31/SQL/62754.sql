SELECT \n    t.name AS TableName,\n    c.name AS ColumnName,\n    c.data_type AS DataType\nFROM \n    sys.tables t\nINNER JOIN \n    sys.columns c ON t.object_id = c.object_id\nWHERE \n    t.type = 'U'\nORDER BY \n    t.name, c.name