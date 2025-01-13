CREATE TABLE mytable(\n  table_identifier_a INTEGER,\n  table_identifier_b INTEGER,\n  table_value1 INTEGER -- Replace with your actual data type\n);\n\n-- Create a partial unique index\nCREATE UNIQUE INDEX unique_identifier_a_value1\nON mytable(table_identifier_a, table_value1)\nWHERE table_identifier_a IS NOT NULL;