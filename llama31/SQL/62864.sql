CREATE TABLE table1 (\n    col1 int,\n    col2 int,\n    col3 AS FLOOR((col1 * 1.0) / col2)\n)