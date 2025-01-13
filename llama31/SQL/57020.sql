WITH RankedTable AS (\n    SELECT T1.*, \n           ROW_NUMBER() OVER (PARTITION BY T1.ID ORDER BY T2.DateStamp DESC) as RN\n    FROM Table1 T1\n    INNER JOIN Table2 T2\n    ON T1.ID = T2.ID\n)\nSELECT *\nFROM RankedTable\nWHERE RN = 1\nORDER BY DateStamp DESC;