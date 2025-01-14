SELECT \n    MAX(CASE WHEN col1 IS NOT NULL THEN col1 END) AS col1,\n    MAX(CASE WHEN col2 IS NOT NULL THEN col2 END) AS col2,\n    MAX(CASE WHEN col3 IS NOT NULL THEN col3 END) AS col3\nFROM (\n    SELECT col1, col2, col3\n    FROM THE_TABLE\n    ORDER BY row_priority\n);