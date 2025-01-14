SELECT \n    MAX(col1) KEEP (DENSE_RANK FIRST ORDER BY CASE WHEN col1 IS NOT NULL THEN 1 ELSE 2 END, row_priority) AS col1,\n    MAX(col2) KEEP (DENSE_RANK FIRST ORDER BY CASE WHEN col2 IS NOT NULL THEN 1 ELSE 2 END, row_priority) AS col2,\n    MAX(col3) KEEP (DENSE_RANK FIRST ORDER BY CASE WHEN col3 IS NOT NULL THEN 1 ELSE 2 END, row_priority) AS col3\nFROM THE_TABLE;