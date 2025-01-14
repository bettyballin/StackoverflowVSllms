-- Find rows in t1 but not in t2\nSELECT t1.*\nFROM t1\nLEFT JOIN t2 ON t1.id = t2.id -- Assuming 'id' is the unique identifier\nWHERE t2.id IS NULL\n\nUNION\n\n-- Find rows in t2 but not in t1\nSELECT t2.*\nFROM t2\nLEFT JOIN t1 ON t2.id = t1.id -- Assuming 'id' is the unique identifier\nWHERE t1.id IS NULL\n\nUNION\n\n-- Find rows where data is different between t1 and t2\nSELECT t1.*\nFROM t1\nJOIN t2 ON t1.id = t2.id -- Assuming 'id' is the unique identifier\nWHERE t1.column1 != t2.column1 OR t1.column2 != t2.column2 -- Compare all columns