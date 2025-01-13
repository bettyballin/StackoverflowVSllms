WITH result1 AS (\n  SELECT *\n  FROM table1\n  WHERE -- Conditions\n),\nresult2 AS (\n  SELECT *\n  FROM table2\n  WHERE -- Conditions\n)\nSELECT *\nFROM result1\nJOIN result2 ON result1.column = result2.column\n-- Continue as necessary