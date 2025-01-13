UPDATE table_name\nSET column_name = 'new_value'\nWHERE id IN (\n  SELECT id\n  FROM table_name\n  WHERE column_name = 'old_value'\n  AND NOT EXISTS (\n    SELECT 1\n    FROM table_name\n    WHERE column_name = 'new_value'\n    AND constraint_column = table_name.constraint_column\n  )\n)