SELECT count(*) \nFROM Table1 \nWHERE NOT EXISTS (\n  SELECT 1 \n  FROM Table2 \n  WHERE Table2.Table1Id = Table1.Table1Id \n    AND Table2.id_user = 1\n)