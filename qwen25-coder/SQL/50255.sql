SELECT TOP 1 t.ID + 1 AS newID\nFROM your_table t\nLEFT JOIN your_table t2 ON t.ID + 1 = t2.ID\nWHERE t.ID > 100000 AND t2.ID IS NULL\nORDER BY t.ID;