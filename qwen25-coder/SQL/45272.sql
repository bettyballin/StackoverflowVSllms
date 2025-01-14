SELECT id, colorName\nFROM (\n    SELECT id, colorName,\n           ROW_NUMBER() OVER (PARTITION BY colorName ORDER BY id) as rn\n    FROM your_table_name\n) AS numbered_rows\nWHERE rn = 1;