UPDATE table\nSET \n    Col1 = CASE \n        WHEN id = 1 THEN 1\n        WHEN id = 2 THEN 2\n        WHEN id = 4 THEN 10\n        ELSE Col1 -- default case, keeps current value if no match\n    END,\n    Col2 = CASE \n        WHEN id = 3 THEN 3\n        WHEN id = 4 THEN 12\n        ELSE Col2 -- default case, keeps current value if no match\n    END\nWHERE id IN (1, 2, 3, 4);