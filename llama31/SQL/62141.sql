SELECT \n    I.INDEX_NAME, \n    I.INDEX_TYPE\nFROM \n    INFORMATION_SCHEMA.INDEXES I\nWHERE \n    I.TABLE_NAME = 'YourTableName';