UPDATE b\nSET b.col1 = CASE \n                WHEN 1 <= 0 THEN 1\n                ELSE 0\n             END\nFROM dbo.table1 b\nINNER JOIN dbo.table1 a\n    ON b.id = a.id\n    AND b.date = a.date