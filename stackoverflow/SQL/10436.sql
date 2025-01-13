SELECT\n    i.Name 'Index Name',\n    OBJECT_NAME(i.object_ID) 'Table Name',\n    c.Name 'Column Name'\nFROM  \n   sys.indexes i \nINNER JOIN \n   sys.index_columns ic ON i.index_id = ic.index_id AND i.object_id = ic.object_id\nINNER JOIN\n   sys.columns c ON ic.column_id = c.column_id AND ic.object_id = c.object_id\nWHERE \n  c.name = 'Index column name'      -- this for a column name\n  -- OBJECT_NAME(i.OBJECT_ID) = 'Table Name'   -- this for table name