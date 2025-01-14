-- Check if the first column is a primary key\nSELECT \n    t.name AS TableName,\n    c.name AS ColumnName,\n    pk.is_primary_key\nFROM \n    sys.tables AS t\nINNER JOIN \n    sys.columns AS c ON t.object_id = c.object_id\nINNER JOIN \n    sys.index_columns AS ic ON t.object_id = ic.object_id AND c.column_id = ic.column_id\nLEFT OUTER JOIN \n    sys.indexes AS pi ON t.object_id = pi.object_id AND ic.index_id = pi.index_id AND pi.is_primary_key = 1\nWHERE \n    ic.key_ordinal = 1 -- First column in the index\nORDER BY \n    t.name, c.column_id;