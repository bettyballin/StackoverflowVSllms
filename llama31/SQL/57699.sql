SELECT \n    OBJECT_NAME(fk.parent_object_id) AS TableName,\n    c.name AS ColumnName\nFROM \n    sys.foreign_keys fk\nINNER JOIN \n    sys.foreign_key_columns fkc ON fk.object_id = fkc.constraint_object_id\nINNER JOIN \n    sys.columns c ON fkc.parent_object_id = c.object_id AND fkc.parent_column_id = c.column_id\nWHERE \n    fk.referenced_object_id = OBJECT_ID('dbo.MainTable')  -- replace with your main table name\n    AND fk.delete_referential_action = 1;  -- 1 = No Action, 2 = Cascade, 3 = Set Null, 4 = Set Default