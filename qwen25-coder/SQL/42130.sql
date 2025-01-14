SELECT col1, col2, derived.new_col1, derived.new_col2\nFROM (\n    SELECT col1, col2, col3,\n           CASE WHEN col3 = 'E01089001' THEN 1 ELSE 2 END AS new_col1,\n           CASE WHEN col3 = 'E01089001' THEN 3 ELSE 4 END AS new_col2\n    FROM Table1\n) derived\nWHERE col1 = 'A0529';