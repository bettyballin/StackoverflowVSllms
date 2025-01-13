SELECT \n  column_name AS first_element,\n  last_column_name AS last_element\nFROM (\n  SELECT \n    column_name,\n    LAG(column_name) OVER (ORDER BY rowid) AS last_column_name\n  FROM table_name\n) WHERE last_column_name IS NOT NULL;