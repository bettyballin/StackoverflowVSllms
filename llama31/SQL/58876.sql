WITH ranked_table_1 AS (\n  SELECT id, ROW_NUMBER() OVER (ORDER BY date) AS row_num\n  FROM table_1\n),\nranked_table_2 AS (\n  SELECT id, ROW_NUMBER() OVER (ORDER BY date) AS row_num\n  FROM table_2\n)\nSELECT id\nFROM ranked_table_1\nWHERE (id, row_num) NOT IN (SELECT id, row_num FROM ranked_table_2)\nUNION ALL\nSELECT id\nFROM ranked_table_2\nWHERE (id, row_num) NOT IN (SELECT id, row_num FROM ranked_table_1);