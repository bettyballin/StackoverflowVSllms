WITH cte AS (\n  SELECT column1, column2, ...\n  FROM table1\n  WHERE ...  -- add filters or transformations as needed\n)\nINSERT INTO table2 (column1, column2, ...)\nSELECT column1, column2, ...\nFROM cte;