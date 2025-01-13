SELECT TABLE_NAME, CONSTRAINT_NAME, COLUMN_NAME\nFROM USER_CONSTRAINTS\nWHERE CONSTRAINT_TYPE = 'R'\nAND R_CONSTRAINT_NAME IN (\n  SELECT CONSTRAINT_NAME\n  FROM USER_CONSTRAINTS\n  WHERE TABLE_NAME = 'PROJECT'\n  AND CONSTRAINT_TYPE = 'P'\n);