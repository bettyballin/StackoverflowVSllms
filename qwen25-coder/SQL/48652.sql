SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE \nFROM INFORMATION_SCHEMA.COLUMNS \nWHERE TABLE_SCHEMA = 'your_database_name' \nAND DATA_TYPE IN ('blob', 'binary', 'varbinary');