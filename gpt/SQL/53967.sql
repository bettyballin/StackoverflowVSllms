SELECT ProductName \nFROM Products \nORDER BY \n  CASE \n    WHEN Position IS NULL THEN 1 \n    ELSE 0 \n  END, \n  Position;