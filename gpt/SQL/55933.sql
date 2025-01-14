SELECT \n    f.name AS constraint_name, \n    OBJECT_NAME(f.parent_object_id) AS table_name, \n    COL_NAME(fc.parent_object_id, fc.parent_column_id) AS column_name, \n    OBJECT_NAME(f.referenced_object_id) AS referenced_table_name, \n    COL_NAME(fc.referenced_object_id, fc.referenced_column_id) AS referenced_column_name\nFROM \n    sys.foreign_keys AS f\nJOIN \n    sys.foreign_key_columns AS fc ON f.object_id = fc.constraint_object_id\nWHERE \n    OBJECT_NAME(f.parent_object_id) = 'your_table'\n    AND SCHEMA_NAME(f.schema_id) = 'your_schema';