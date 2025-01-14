-- Original query with many LEFT JOINs (example)\nSELECT *\nFROM table1 t1\nLEFT JOIN table2 t2 ON t1.id = t2.table1_id\nLEFT JOIN table3 t3 ON t1.id = t3.table1_id\n-- and so on up to 5+ joins\n\n-- Optimized query: Break it into smaller, more manageable queries or use subqueries/cte\nWITH cte_table2 AS (\n    SELECT * FROM table2\n),\ncte_table3 AS (\n    SELECT * FROM table3\n)\nSELECT *\nFROM table1 t1\nLEFT JOIN cte_table2 t2 ON t1.id = t2.table1_id\nLEFT JOIN cte_table3 t3 ON t1.id = t3.table1_id;