SELECT id, name\nFROM (\n  SELECT id, name, row_number() OVER (ORDER BY name) AS row_num\n  FROM table\n) AS subquery\nWHERE row_num BETWEEN (SELECT row_num - 2 FROM subquery WHERE id = 47) AND (SELECT row_num + 2 FROM subquery WHERE id = 47);