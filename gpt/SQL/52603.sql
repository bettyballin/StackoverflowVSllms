SELECT main.*, a_filtered.*\nFROM main\nLEFT JOIN (\n    SELECT a.col1, a.col2\n    FROM a\n    INNER JOIN b ON a.col3 = b.col3\n) a_filtered ON main.col2 = a_filtered.col2;