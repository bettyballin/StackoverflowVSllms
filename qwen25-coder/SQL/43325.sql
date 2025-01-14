SELECT \n    TABLE_NAME,\n    COLUMN_NAME,\n    CONSTRAINT_NAME,\n    REFERENCED_TABLE_SCHEMA,\n    REFERENCED_TABLE_NAME,\n    REFERENCED_COLUMN_NAME \nFROM \n    INFORMATION_SCHEMA.KEY_COLUMN_USAGE \nWHERE \n    REFERENCED_TABLE_NAME = 't21_turma' AND \n    REFERENCED_COLUMN_NAME = 'A21_ID';