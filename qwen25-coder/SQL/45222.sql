SELECT \n    kcu.CONSTRAINT_NAME,\n    tc.CONSTRAINT_TYPE\nFROM \n    INFORMATION_SCHEMA.KEY_COLUMN_USAGE kcu\nJOIN \n    INFORMATION_SCHEMA.TABLE_CONSTRAINTS tc ON kcu.CONSTRAINT_NAME = tc.CONSTRAINT_NAME\nWHERE \n    kcu.TABLE_NAME = @TableName\n  AND kcu.COLUMN_NAME = @ColumnName;