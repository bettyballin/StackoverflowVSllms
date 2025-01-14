SELECT foo\nFROM (\n    SELECT foo, ROW_NUMBER() OVER(ORDER BY some_column) AS RowNum\n    FROM table\n) AS numbered_rows\nWHERE RowNum > 10 AND RowNum <= 20;