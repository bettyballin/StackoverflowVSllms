SELECT t1.userID, \n       t2_unit.answer AS Unit, \n       t2_demo.answer AS Demo  \nFROM table1 t1  \nINNER JOIN (    -- Get latest "Unit" row per user\n    SELECT userID, answer\n    FROM (\n        SELECT *, ROW_NUMBER() OVER(PARTITION BY userID ORDER BY counter DESC) as rn\n        FROM table2 WHERE question = 'Unit'\n    ) subQuery \n    WHERE rn = 1  \n) t2_unit ON t1.userID = t2_unit.userID  \nINNER JOIN (    -- Get latest "Demo" row per user\n    SELECT userID, answer\n    FROM (\n        SELECT *, ROW_NUMBER() OVER(PARTITION BY userID ORDER BY counter DESC) as rn\n        FROM table2 WHERE question = 'Demo'\n    ) subQuery \n    WHERE rn = 1  \n) t2_demo ON t1.userID = t2_demo.userID  \nWHERE t1.date > '2009-01-01'  \nORDER BY t1.userID;