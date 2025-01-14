SELECT \n    C.COLUMN_NAME,\n    C.DATA_TYPE,\n    RC.CONSTRAINT_NAME AS ForeignKeyConstraintName,\n    KCU2.TABLE_NAME AS ForeignTableName,\n    KCU2.COLUMN_NAME AS ForeignColumnName\nFROM \n    INFORMATION_SCHEMA.COLUMNS C\nLEFT JOIN \n    INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS RC ON C.TABLE_CATALOG = RC.CONSTRAINT_CATALOG\n    AND C.TABLE_SCHEMA = RC.CONSTRAINT_SCHEMA\nLEFT JOIN \n    INFORMATION_SCHEMA.KEY_COLUMN_USAGE KCU1 ON C.COLUMN_NAME = KCU1.COLUMN_NAME \n    AND C.TABLE_NAME = KCU1.TABLE_NAME \n    AND C.TABLE_SCHEMA = KCU1.TABLE_SCHEMA \n    AND RC.CONSTRAINT_NAME = KCU1.CONSTRAINT_NAME\nLEFT JOIN \n    INFORMATION_SCHEMA.KEY_COLUMN_USAGE KCU2 ON RC.UNIQUE_CONSTRAINT_CATALOG = KCU2.CONSTRAINT_CATALOG\n    AND RC.UNIQUE_CONSTRAINT_SCHEMA = KCU2.CONSTRAINT_SCHEMA\n    AND RC.UNIQUE_CONSTRAINT_NAME = KCU2.CONSTRAINT_NAME\n    AND KCU1.ORDINAL_POSITION = KCU2.ORDINAL_POSITION\nWHERE \n    C.TABLE_NAME = 'Customers';