CREATE TABLE test (\n  enum_column ENUM('a', 'b', 'c', ..., 'z')  -- 26 values\n);\n\nSELECT \n  COLUMN_NAME, \n  DATA_TYPE, \n  CHARACTER_MAXIMUM_LENGTH, \n  NUMERIC_PRECISION, \n  NUMERIC_SCALE \nFROM \n  INFORMATION_SCHEMA.COLUMNS \nWHERE \n  TABLE_NAME = 'test' AND COLUMN_NAME = 'enum_column';