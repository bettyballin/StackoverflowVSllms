SELECT \n       TABLE_NAME, \n       COLUMN_NAME, \n       REFERENCED_TABLE_SCHEMA, \n       REFERENCED_TABLE_NAME, \n       REFERENCED_COLUMN_NAME \n   FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE \n   WHERE TABLE_SCHEMA = 'your_database_name' \n     AND TABLE_NAME = 'your_table_name'\n     AND REFERENCED_TABLE_NAME IS NOT NULL;