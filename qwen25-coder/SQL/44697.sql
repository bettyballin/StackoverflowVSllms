SELECT COLUMN_NAME\nFROM INFORMATION_SCHEMA.COLUMNS\nWHERE TABLE_NAME = 'YourTableName'\nAND TABLE_CATALOG = 'YourDatabaseName';