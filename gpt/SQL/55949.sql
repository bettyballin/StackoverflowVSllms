SELECT \n    CONSTRAINT_NAME, \n    TABLE_NAME, \n    COLUMN_NAME, \n    REFERENCED_TABLE_NAME, \n    REFERENCED_COLUMN_NAME\nFROM \n    INFORMATION_SCHEMA.KEY_COLUMN_USAGE\nWHERE \n    TABLE_SCHEMA = 'your_schema' \n    AND TABLE_NAME = 'your_table' \n    AND REFERENCED_TABLE_NAME IS NOT NULL;